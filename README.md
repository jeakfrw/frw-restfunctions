# Plugin template for Jeak plugins
Users can create new plugins from this template repository either by manual cloning or via the templating mechanism of GitHub.  

## How to use the template
1. Set your plugin ID in ``project.ext => artifact``. It will be used to generate the plugin Jar file.  
2. Create your plugin package below ``src/main/java/`` (convention here is to use reverse domain notation here too)
3. Create your plugin class in ``src/main/java/<your-package>``  
4. Happy programming! :) (Remember to visit [the documentation](https://jeakbot.readme.io) and feel free to ask for help in case you need it)
5. Remember to change/check the license file for your plugin ;)

## Setting up Git
In case you cloned the template, remember to change the ``origin`` remote that is automically registered when cloning a project:  
```bash
# Remove the old remote reference
git remote remove origin
# Add the new remote reference
git remote add origin <your-repository-uri>
```  

Your can also just rename the remote reference so that you can always pull updates to the template:  
```bash
# Rename remote reference
git remote rename origin template
# Add the new remote reference as default
git remote add origin <your-repository-uri>

# Pull any updates to the template (from the templates 'master' branch to the currently checked out branch)
# We recommend using an interactive merge tool. And: remember not accept changes to files like this readMe ^^ - this is yours now.
git pull template master
```
