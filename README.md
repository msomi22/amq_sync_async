# amq_sync_async
A demo application on how to send synchronous and asynchronous messages using AMQ.

* Sync - Endpoint 
* http://localhost:8080/send/v1 
* Sample Request
```JSON
{
	"id": 100,
	"mobile": "0718953974",
	"email": "mwendapeter72@gmail.com",
	"account": "254718953974"
}
```
* Sample Response
```JSON
{
    "originatorId": "100",
    "id": "d602ff69-d36e-48ef-a7a5-58d706e2d73d",
    "message": "Request was successful"
}
```
* Clone this branch to view the source code

```JSON
curl --url 'http://localhost:8080/send/v1' --header 'Content-Type:application/json' --data '{"id": 100, "mobile": "0718953974", "email": "mwendapeter72@gmail.com","account": ""}'

{"originatorId":"100","id":"100","message":"Ack"}


curl --url 'http://localhost:8080/send/v1' --header 'Content-Type:application/json' --data '{"id": 100, "mobile": "0718953974", "email": "mwendapeter72@gmail.com","account": "12344556"}'


{"originatorId":"100","id":"7c909af3-4482-43bd-b759-edffdb2a658a","message":"Request was successful"}

```
