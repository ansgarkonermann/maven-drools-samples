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

public class Income {

  private Person earnedBy;

  private double yearlyAmount;

  public Person getEarnedBy() {
    return earnedBy;
  }

  public void setEarnedBy(Person earnedBy) {
    this.earnedBy = earnedBy;
  }

  public double getYearlyAmount() {
    return yearlyAmount;
  }

  public void setYearlyAmount(double yearlyAmount) {
    this.yearlyAmount = yearlyAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }

    Income income = (Income) o;

    if (Double.compare(income.yearlyAmount, yearlyAmount) != 0) { return false; }
    if (earnedBy != null ? !earnedBy.equals(income.earnedBy) : income.earnedBy != null) { return false; }

    return true;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = earnedBy != null ? earnedBy.hashCode() : 0;
    temp = yearlyAmount != +0.0d ? Double.doubleToLongBits(yearlyAmount) : 0L;
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
