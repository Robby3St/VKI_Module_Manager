# VKI Module Manager
A very small manager to organize little projects (ordered in modules) within a single Java Project.

## Install

Install the project by downloading it and import it to your development environment of your choice. When you want to create your own modules inside the VKI Manager, you can simpy create a new class in the modules package and copy the whole DemoClass from the module package. Now, you should customize the information at the top of the class and rename the class itself to belong to your needs. It is recommended that you put your main code into seperate methods outside of the modules' main method to keep some order. The 'runModule()' method is like the main function in Java and is the entry point of your code. 

Once, your module is done to be executed, you can configure the VKI Module Manager in the Main class in the main package. Feel free to activate some of the information display settings with the instance of the manager (just type 'manager.enable' in an IDE with auto complete turned on and you should start to see some additional information, you can activate to keep track of the loaded modules). When you want, to load your own new module, just copy the line above and fit in your own module name (please don't forget to import it too!). You can also remove the other loaded modules to keep the output clean. It is also possible to unload modules with the 'manager.unload(VkiModule mod)' method. 
