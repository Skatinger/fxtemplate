# fxtemplate
a template on how to use FXML in java


Some info:

The project is made up of 4 files.


FXTemplate.java:
This is the main file containing the start and main functions. It will start the application.

FXMLDocumentController:
This file initializes your UI with the given fxml file. It also controls all kinds of actions that happen on the GUI. It is therefore the controller of the GUI.

FXMLDocument.fxml:
this document contains an xml structure that tells the controller how it should initialize the GUI. It contains all information on how components are structured, where they are placed, what styles they have and how they interact with the user.

stylesheet.css:
this contains, as all css files, standard css which can be referenced in the fxml file to give some styling to all kinds of parts. main difference to standard web css is the "-fx-" prefix. Most web css can be used.


Why is my project not working?
Most common reasons for it not to be working:
To be able to use actionListeners on your elements the fxml file has to specify the controller in the root element. For example with an Anchorpane as root element this could look like this:

<AnchorPane ...some properties... controller="packagename.MyController">
  ... all inner elements ....
</AnchorPane>

The GUI will show without this controller-specification, but as soon as actionHandlers are added it will crash upon initialization.

Another problem could be that you specified an actionHandler in an element with the syntax #actionHandlerMethodName inside an element. The corresponding handler method in your controller must have the exact same name and be annotated with the @FXML.

Further Info:
To reference an element inside your UI you have to specify an id inside the fxml with id="your_id".
In your controller right after the start of the class declare your element with the @FXML annotation:

@FXML
Button my_button_id;

Then you can reference it throughout the controller.


Other tipps:
An fxml file is easiest built with the program scenebuilder. https://gluonhq.com/products/scene-builder/
Some IDE's have built in functionality to generate controllers from your FXML file. (Netbeans 8.2, intellij)
IDE's can be cuppled with Scenebuilder to start it right from your IDE. You can also start it independently if you wish.




