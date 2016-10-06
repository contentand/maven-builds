###Task:
Create project with 2 types of test - ITest and simple test. Configure maven to run build without ITests. Create profile to run build with ITests, only ITests. Use maven properties to configure ITest name convention.

***
###Comments:
By default only simple test will run:
   ```bash
   mvn test
   ```
To run ITest only launch with the profile ***itest-only***:
   ```bash
   mvn test -P itest-only
   ```
To run both tests launch with the profile ***both-test***:
   ```bash
   mvn test -P both-test
   ```
