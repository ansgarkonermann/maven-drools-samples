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

import com.example.scoring.facts.Income;
import com.example.scoring.facts.LoanPart;
import com.example.scoring.facts.Person;

import java.util.ArrayList;
import java.util.List;

public class ScoringRequest {

  private List<Person> applicants = new ArrayList<Person>();

  private List<LoanPart> loanParts = new ArrayList<LoanPart>();

  private List<Income> incomes = new ArrayList<Income>();

  public List<Person> getApplicants() {
    return applicants;
  }

  public void addApplicant(Person applicant) {
    applicants.add(applicant);
  }

  public List<LoanPart> getLoanParts() {
    return loanParts;
  }

  public void addLoanPart(LoanPart loanPart) {
    loanParts.add(loanPart);
  }

  public List<Income> getIncomes() {
    return incomes;
  }

  public void addIncome(Income income) {
    incomes.add(income);
  }
}
