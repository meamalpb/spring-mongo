# Simple springboot crud application with mongodb as its database
## To run
* open in intellij
* create a cluster in mongo atlas and put the link in application.yml
* or connect to your local mongo db

# Routes

* Get tasks - http://localhost:8080/tasks
* Update tasks - http://localhost:8080/tasks/{id} (put mapping)
* Add task - http://localhost:8080/tasks (post request with task as body)
* Delete task - http://localhost:8080/tasks/{id} {delete request}
* Get Task by assignee - http://localhost:8080/tasks/assignee/{assignee}
* Get Task by id - http://localhost:8080/tasks/{id}
* Get Task by severity -http://localhost:8080/tasks/severity/{severity}
