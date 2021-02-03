# Parallelism module for Mendix

This module allows you to spin up background threads which will execute a microflow. This will keep on running as long as the application is running.

One defines a certain amount of threads which are running <u>per instance</u>. 

## Typical usage scenario

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



## Installation

Attach the `Parallelism.BeforeShutdown` microflow to your *Before shutdown* procedure to let the threads finish gracefully before the Runtime is shut down.

## Configuration

Use the `Execute in background` action to create new threads.

