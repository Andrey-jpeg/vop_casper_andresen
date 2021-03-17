# Callback

## Tasks

We have provided a demo of a running code where part of the code are missing. Study the code and implement below tasks in the `PrimaryController.java` file.

### Task 1

Implement the `buttonAction()` such that the events from the startButton
- Creates a new instance of `FacadeWithCallBack` and passes the `PrimaryController` as a parameter.
- Starts the new instance of the `FacadeWithCallBack` thread
- Enables the `stopButton` and disables the `startButton`

### Task 2

Implement the `buttonAction()` such that the events from the `stopButton`
- Calls `Interrupt()` on the `FacadeWithCallBack` instance
- Disables the `stopButton` and enables the `startButton`

### Task 3

Implement the `updateMessage()` such that
- The instance of the `FacadeWithCallBack` appends new messages into the textArea
- The `stopButton` fires, if the `FacadeWithCallBack` thread is not alive.

### Task 4

Implement the `updateImages()` such that
- The instance of the `FacadeWithCallBack` sets two new images to both the `die1View` and `die2View`w
respectively.