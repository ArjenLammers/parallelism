# Parallelism module for Mendix

This module implements several patterns to execute logic in parallel. The patterns implemented:

- Create repeating background threads (execute microflow in background)
- Execute microflow asynchronous including Futures (**experimental**!)



## Create repeating background threads

This allows you to spin up background threads which will execute a microflow. One defines a certain amount of threads which are running <u>per instance</u>. 

 This will keep on running as long as the application is running.

### Typical usage scenario

The scenario must be:

- Multi-threaded
- Repeating
- Running in the background
- Running autonomously

The most common concrete scenario is for polling (e.g. polling a message from a queue).

**Important!**:

To avoid overconsumption of (remote) resources, verify the following:

- Set a *Sleep* value of the `ExecuteInBackground` action.
- Your microflow should return a Boolean value. It should be:
  - True: when it was successful (so there might be more work; let's poll again asap)
  - False: if an error occurred or there was no work to do

### Error handling

To keep in mind:

- Each microflow will be executed in its own context/transaction
- The module will end the transaction, if left open for some reason
- Uncatched errors will be catched and will cause a 30 sec pause between executions

### Installation

Attach the `Parallelism.BeforeShutdown` microflow to your *Before shutdown* procedure to let the threads finish gracefully before the Runtime is shut down.

### Configuration

Use the `Execute in background` action to create new threads.



## Execute microflow asynchronously (EXPERIMENTAL!)

This hasn't been thoroughly tested. If you decide to use it, let me know your experiences!

Please note that only the object passed as argument is directly accessible (since it's running in a separate context).

### Typical use case scenario

Fitting this line of thought:

- During a flow of execution there could be work which can be executed in parallel.
- You need the outcome later in your flow.
- It can run in a separate transaction (or doesn't use the database at all).

### Configuration

To use this functionality:

- Use the `Parallellism.ExecuteMfAsync` action to execute a microflow in parallel, it will return a `Parallelism.Future` object.
- Use the `Parallelism.GetMfAsyncResult` action to wait for the asynchronous executed microflow to finish and to obtain its result.







