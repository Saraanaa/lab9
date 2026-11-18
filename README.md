# Lab 09 - JaCoCo coverage

Student name: Saraanaa  
Student code: not provided

## Environment

```text
java version "22.0.2" 2024-07-16
Java(TM) SE Runtime Environment (build 22.0.2+9-70)
Java HotSpot(TM) 64-Bit Server VM (build 22.0.2+9-70, mixed mode, sharing)

Apache Maven 3.9.11
Java version: 22.0.2
OS name: Windows 11, arch: amd64
```

## A - Happy path

Five initial JUnit tests cover the main successful flows: A and B grades, GPA for two scores, full scholarship, and the violation rule. The result is stored in `results/mvn-verify-A.txt` and `results/jacoco-A.csv`. The initial report shows 14/25 lines and 18/41 branches covered; the uncovered red paths are mainly validation, lower grades, and scholarship alternatives.

## B - CFG and 100% coverage

`cfg.png` shows the control-flow graph for `scholarship()`. Additional tests cover every grade case, every scholarship award, all validation exceptions, and all short-circuit sides. `results/mvn-verify-B.txt` records 9 passing tests. `results/jacoco-B.csv` has `BRANCH_MISSED=0` and `LINE_MISSED=0`.

## C - Boundary tests

The GPA tests explicitly cover the three required input-size boundaries:

- zero items: an empty array throws `IllegalArgumentException`;
- one item: `gpa([95]) == 4.0`;
- two or more items: `gpa([95, 85, 75, 65]) == 2.5`.

These tests do not add a new branch because the existing B tests already covered the same paths, but they document the boundary requirement clearly.

## D - Specification bug and fix

The initial implementation used `score > 60`, so the valid boundary score `60` incorrectly returned `F`. The D test exposed `expected: <D> but was: <F>`; the original failing run is preserved in `results/mvn-test-D-fail.txt`. The fix changed the condition to `score >= 60` in a separate D commit. The final run has 12 passing tests and `results/jacoco-final.csv` reports `BRANCH_MISSED=0` and `LINE_MISSED=0`.

Coverage is evidence that executed branches and lines were exercised; it is not proof that the specification is correct. The boundary test was necessary to reveal this semantic error even though the earlier report already showed 100% branch coverage.

## AI disclosure

AI assistance was used to organize the JUnit tests, interpret the JaCoCo CSV output, and draft the CFG/README. The code was run locally, the failing boundary test was observed, and the final fix and reports were verified with Maven.
