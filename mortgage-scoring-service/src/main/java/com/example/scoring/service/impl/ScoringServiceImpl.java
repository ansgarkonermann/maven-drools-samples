/*
 * Copyright (c) 2009-2011 Ansgar Konermann
 *
 * This file is part of the Maven 3 Drools Plugin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.scoring.service.impl;

import com.example.scoring.api.ScoringRequest;
import com.example.scoring.api.ScoringResponse;
import com.example.scoring.api.ScoringService;
import com.example.scoring.facts.ScoringFinding;
import de.lightful.maven.plugins.drools.knowledgeio.KnowledgePackageFile;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.definition.KnowledgePackage;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ScoringServiceImpl implements ScoringService {

  public ScoringResponse scoreMortgageApplication(ScoringRequest request) throws RuntimeException {
    try {
      final KnowledgeBase knowledgeBase = loadKnowledgeModule();
      final StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();

      fillWorkingMemory(session, request);

      session.fireAllRules();
      return extractScoringResult(session);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private ScoringResponse extractScoringResult(StatefulKnowledgeSession session) {
    ScoringResponse response = new ScoringResponse();

    final QueryResults queryResults = session.getQueryResults("extractFindings");
    for (QueryResultsRow queryResult : queryResults) {
      response.addFinding((ScoringFinding) queryResult.get("$finding"));
    }
    return response;
  }

  private void fillWorkingMemory(StatefulKnowledgeSession session, ScoringRequest request) {
    addAllFacts(session, request.getApplicants());
    addAllFacts(session, request.getIncomes());
    addAllFacts(session, request.getLoanParts());
  }

  private void addAllFacts(StatefulKnowledgeSession session, List<?> facts) {
    for (Object fact : facts) {
      session.insert(fact);
    }
  }

  private KnowledgeBase loadKnowledgeModule() throws IOException, ClassNotFoundException {
    String businessRulesFileName = getClass().getResource("/").getFile() + "../../../mortgage-scoring-rules/target/mortgage-scoring-rules-0.0.13.dkm";
    KnowledgePackageFile knowledgePackageFile = new KnowledgePackageFile(new File(businessRulesFileName));
    final Collection<KnowledgePackage> knowledgePackages = knowledgePackageFile.getKnowledgePackages();

    final KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
    knowledgeBase.addKnowledgePackages(knowledgePackages);
    return knowledgeBase;
  }
}
