# Lab Report 1

## Hello fellow CSE 15L students! This is a tutorial on how to set up and ssh(login) into your course-specific CSE 15L account in the remote ieng6 server, run a few commands in the remote server, and install and set up VSCode in your local environment.
## NOTE: This tutorial is created specifically for students who poses a version of the Mac operating system(OS). Although many of the steps are similar to what you would do in a Windows OS, some steps might differ.

**Steps:**
1. Installing VSCode:

  First, you might ask what is VSCode. That's a great question! VSCode is an Integrated Development Environment(IDE). What is an IDE? In simple terms, an IDE is a special software tool that helps you write and create computer programs. It's like a digital workshop where you can build and shape your ideas into working software. Think of an IDE as a bundle of useful tools that make your programming tasks easier. It's designed to help you write code, test it, and fix any mistakes or bugs you encounter along the way. With an IDE, you don't have to juggle multiple programs or manually set up everything yourself. It provides a convenient and organized workspace for your coding projects. These are the key components you'll find in an IDE:
	* Code editor: The code editor is like a digital notebook where you write your program's instructions. It has features like color-coding (syntax highlighting) to make your code easier to read, and it helps you spot mistakes in real-time. The editor also offers suggestions as you type, saving you time and effort.
	* Compiler or Interpreter: These are the tools that take your written code and turn it into something the computer can understand and execute. A compiler converts your entire program into an executable file, while an interpreter processes and runs the code line by line.
	* Debugger: Finding and fixing bugs can be challenging, but the debugger is there to help. It lets you pause your program at specific points to see what's happening step by step. You can examine the values of variables and identify where things might be going wrong, making it easier to correct errors.
	* Build Tools: As your programs become more complex, you'll need additional tools to manage them. Build tools help you compile your code, package it together, and handle any dependencies (extra pieces of code your program relies on). They make sure your program is ready to run correctly.
	* Version Control: Version control tools help you manage different versions of your code. They allow you to save snapshots of your project at various stages, track changes, and collaborate with others without overwriting each other's work. It helps you keep your code organized and enables teamwork.

  To install VSCode:
1. Open up your favorite internet browser(Chrome, Firefox, Safari, etc.)
2. In the search bar type the following link: [https://code.visualstudio.com/download](https://code.visualstudio.com/download).
	![Image](https://github.com/AlbardEspinoza/cse15l-lab-reports/blob/main/VSCode_download_page.png)

  3. To choose the correct version of VSCode to download you need to know exactly which version of the macOS you're running as well as some hardware specs of your laptop. To do this go to your Mac's menu bar and click the Apple logo and select the first option labeled: **About This Mac**. This will open up an overview of your laptop's specifications(see the image below) like the version of macOS as well as the processor. If your laptop is running a macOS version 10.11+ then select the version of VSCode that is under the Apple logo labeled **macOS 10.11+**. If it's running a previous version you will have to download the .zip files based on the processor that you're laptop has. If the processor section of your laptop's specs states that is using Intel, then select the .zip file labeled **Intel chip**. If you have one of the latest Mac laptops you might have an M1 or M2 processor. If that's the case choose the .zip file labeled **Apple silicon**. ![Image](https://github.com/AlbardEspinoza/cse15l-lab-reports/blob/main/Laptop_specs_example.png)
  4. After selecting the option in the previous step you will be redirected to a download page(see the image below) and VSCode will automatically start downloading. If VSCode does not automatically start downloading within a minute, click on the link in the page labeled **direct download link**.![Image](https://github.com/AlbardEspinoza/cse15l-lab-reports/blob/main/Download_link.png)
  5. After VSCode is finished downloading, open Finder and select the Downloads section. To spot the VSCode download quickly you can right-click on Finder and click on the option **Sort By > Date Created**. Depending on the VSCode version you downloaded the .zip file in your downloads will generically be labeled **VSCode-some_text.zip**. Double-click that .zip file.
  6. Next you will see the VSCode application being created in your Downloads folder(see the image below). You need to move VSCode from your Downloads directory to your Applications directory. To do that you can just easily drag the VSCode icon within the Downloads directory and drop it in the Applications directory within the Finder window.![Image](https://github.com/AlbardEspinoza/cse15l-lab-reports/blob/main/VSCode_downloaded_app.png)
  7. Next, the macOS will ask you for your user password to be able to move VSCode in the Applications directory. Type is and press Enter.
  **Success** :thumbsup: You have successfully installed VSCode to your local environment. Feel free to open and play around with the IDE.

2. Remotely connecting to the ieng6 server

  What exactly does it mean to "Remotely connect to the ieng6 server"? Think of a server as a powerful computer that stores and manages data, runs applications, or provides services to other computers or devices. It could be a web server that hosts websites, a file server that stores files, or a database server that manages data. When you remotely connect to a server, it means you're able to interact with and control that server as if you were physically sitting in front of it, even if you're in a different location. It allows you to perform various tasks and manage the server's resources, settings, and data without directly accessing it. Overall, remotely connecting to a server allows you to control and manage a computer server from a different location, enabling efficient administration and utilization of resources.
  * **Prerequisites**: Before we begin this step you need to have access to your course-specific CSE 15L account. I will explain how to look up your username to your account and reset the password.
    1. Head to the following link: [https://sal.ucsd.edu/students/a16619808](https://sal.ucsd.edu/students/a16619808). You will need to provide your Student Single Sign-On credentials.
    2. When you log in you will see a dashboard will all the resources that are provided in the classes that you're taking. One of them will be labeled "CSE15L" (see image displayed below). The username that is circled in the image below will be your username to log into the remote server. Make sure you write this down.![Image](https://github.com/AlbardEspinoza/cse15l-lab-reports/blob/main/account_lookup.png)
    3. You need to reset the password for that account. Head to the following link: [http://password.ucsd.edu/](http://password.ucsd.edu/). You will be redirected to a password change tool. At the bottom of the page, you will see a prompt asking for the username of the account you want to reset the password. Provide the username you got in step 3.
    4. A link will show up labeled "I want to reset my course-specific account", click it.
    5. You will need to verify your UCSD student email address on the following page. When you do, an email will be sent to your student email address with a link to reset your CSE 15L account password.
    6. Look up the email. The subject should be "Password Reset".
    7. Click the link labeled "UCSD Password Reset Page".
    8. It will ask for a new password with some requirements listed on the side of the page.
    9. You will need to type the password a second time to verify it.
    10. Submit it and wait a few minutes until the system processes the request.

  To remotely connect to the ieng6 server:
    1. Open the Terminal. This is a command-line interface that lets you interact with the operating system.
    2. Type the following command: **ssh <your_username>@pi-cluster**. What does this command do? The ssh command stands for Secure Shell, and it is used to establish a secure and encrypted connection between your local computer and a remote computer or server over a network. It allows you to log in to a remote machine and execute commands on that machine as if you were sitting right in front of it.
    3. Since this will be your first time connecting to this server a few things will happen:
      * Since it's your first time connecting to the server, your SSH client doesn't recognize the server's identity. As a security measure, the SSH client displays a warning to let you know that it cannot verify the authenticity of the server.
      * o ensure you are connecting to the correct server and not a malicious one, SSH uses a fingerprint—a unique identifier generated from the server's public key. Your SSH client calculates the fingerprint and displays it to you.
      * At this point, you need to manually verify the server's fingerprint. This involves comparing the displayed fingerprint with a trusted fingerprint obtained through a secure channel. This verification step ensures that you are connecting to the intended server.
      * If the fingerprint matches and you trust the server's identity, you can proceed to accept the server's public key. By accepting the key, you inform your SSH client that you trust this server and want to establish a secure connection.
      * Once you accept the server's public key, your SSH client adds the key to a file called "known_hosts." This file acts as a record of trusted servers. In future connections, your SSH client will automatically check this file to verify the server's identity.

      The previous steps will only occur the first time you ssh into the server.

    4. Finally you will be asked to provide your credentials. Type the password you used to reset your password.
    5. You have successfully logged into the remote ieng6 server :thumbsup:

3. Finally, let's try a few commands in the server to get familiar with the environment.
    1. You're probably curious about what's in this remote server. Like files, pictures, etc. Type the command **ls -a**. This command will list all the files that are present in that directory. Including the hidden files that do not show up on Finder.
    2. You might also be curious about which directory you're on right now. Type **pwd**. This command will print to the terminal the directory that you're currently on.
    3. Lastly, let's try out making a directory in your current working directory. Type **mkdir test**. This command will create a directory in your current working directory named test! See the image below listing examples of running the commands.![Image](https://github.com/AlbardEspinoza/cse15l-lab-reports/blob/main/command_examples.png)

You're all set to begin in CSE 15L. Hope this tutorial was helpful! If you need any extra help don't hesitate to ask your TAs or attend your professor's office hours.
