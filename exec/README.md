###Task:
Create project with exec plugin. Main class should work with parameters. Write command examples for maven to run project. Create build profile that will turn on exec plugin. Use property to specify main class.  

***
###Comments:
Exec:java plugin goal is associated with the package goal.  
To activate exec plugin activate ***executable*** profile:  
   ```bash
   mvn package -P executable
   ```   
   This will call main method defined in ***com.dy.maven.Boot***.     
   It will also pass default argument ***Peter***.   
       
  If you want to customize the main class and/or the arguments passed,    
  redefine the properties ***exec.main*** and ***exec.args***:   
```bash
  mvn package -P executable 
      -Dexec.main=com.dy.maven.YetAnotherBoot 
      -Dexec.args="'yay' 'nice'"
```   
