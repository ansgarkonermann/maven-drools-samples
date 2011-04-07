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
package com.example.scoring.api;

import com.example.scoring.facts.ScoringFinding;

import java.util.ArrayList;
import java.util.List;

public class ScoringResponse {

  private List<ScoringFinding> findings = new ArrayList<ScoringFinding>();

  public List<ScoringFinding> getFindings() {
    return findings;
  }

  public void addFinding(ScoringFinding finding) {
    findings.add(finding);
  }
}
