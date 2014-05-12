grizzly-1679
============

Client code for Grizzly Bug #1679 (https://java.net/jira/browse/GRIZZLY-1679)

Usage
-----

Pass URL as a parameter 

```
mvn exec:java -Dexec.args="{URL}"
```

For example:

```
mvn exec:java -Dexec.args="http://www.example.com"
```

If the bug is triggered, you will see the following output:
 
```
== Bug Hit! ==
Caught Exception java.util.concurrent.ExecutionException: java.io.IOException: Remotely Closed
```

