###Task:
Create project with sql data. Use Flyway* or liquibase plugin to populate dbdata.

***
###Comments:
Liquibase plugin was used to populate dbdata.
For simplicity H2 database was chosen. No setup is required from the user.
To launch the app run:  
   ```bash
   mvn package
   ```   
   This will create a new schema in H2 called **base**, 
   create appropriate tables, constraints and data according to logs. 
   Finally, the main method defined in ***com.dy.maven.Boot*** will be called. 
   It will print the content of the db including some columns of ***databasechangelog*** table.
       
  The output looks like:   
```bash
--------- USERS AND ROLES ----------

username: daniil.yurov
password: secret_password
enabled: true
roles: [BOSS, LEAD]

username: artem.pryzhkov
password: awesome_password
enabled: true
roles: [BUSINESS-PARTNER, ASSOCIATE, INVESTOR]
-------------------------------------
------- DATABASE CHANGE LOGS --------

id: 0.1T1
author: daniil.yurov
filename: db-changelog/db.changelog-0.1.xml
description: createTable tableName=user
comments: Table created: user(username, password).

id: 0.1T2
author: daniil.yurov
filename: db-changelog/db.changelog-0.1.xml
description: createTable tableName=role
comments: Table created: role(id, username, role).

id: 0.1C1
author: daniil.yurov
filename: db-changelog/db.changelog-0.1.xml
description: addForeignKeyConstraint baseTableName=role, constraintName=FK_user_role, referencedTableName=user
comments: FK added user.username -> role.username.

id: 0.1D1
author: daniil.yurov
filename: db-changelog/db.changelog-0.1.xml
description: insert tableName=user; insert tableName=role; insert tableName=role
comments: Data inserted into user, role.

id: 0.2T1
author: daniil.yurov
filename: db-changelog/db.changelog-0.2.xml
description: addColumn tableName=user
comments: Table update: user(... + enabled).

id: 0.2D1
author: daniil.yurov
filename: db-changelog/db.changelog-0.2.xml
description: insert tableName=user; insert tableName=role; insert tableName=role; insert tableName=role
comments: Data inserted into user, role.
-------------------------------------
```   
