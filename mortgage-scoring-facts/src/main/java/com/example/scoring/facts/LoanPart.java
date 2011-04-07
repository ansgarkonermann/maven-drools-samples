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
package com.example.scoring.facts;

public class LoanPart {

  private LoanPartType type;

  private double amount;

  private int durationInMonths;

  public LoanPartType getType() {
    return type;
  }

  public void setType(LoanPartType type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public int getDurationInMonths() {
    return durationInMonths;
  }

  public void setDurationInMonths(int durationInMonths) {
    this.durationInMonths = durationInMonths;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }

    LoanPart loanPart = (LoanPart) o;

    if (Double.compare(loanPart.amount, amount) != 0) { return false; }
    if (durationInMonths != loanPart.durationInMonths) { return false; }
    if (type != loanPart.type) { return false; }

    return true;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = type != null ? type.hashCode() : 0;
    temp = amount != +0.0d ? Double.doubleToLongBits(amount) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + durationInMonths;
    return result;
  }
}
