# First Git Steps

Your team's repository is set up on GitHub under GitHub Classroom management.  You should use this repository
to collaborate on the software development in your project (and learn Git while you're at it). 

The main actions you'll require are:
1. set up your local repo as a clone of the GitHub remote repo
2. make changes on your individual branch in your local repo
3. push changes to the remote repo via a "pull-request"
4. pull changes from the remote repo.

# Set up local repo

Review this image to see parts of the GitHub page for your team's repository: [GitHub repo image](git-repo-url.png).

In the command/terminal window, issue the following commands to clone the remote repo and use your branch. 
Replace REMOTE_URL with the URL of your team's repo.  Find this URL by clicking the "Clone or download" button in the image.
Figure out the name of the local repo (top left in the image) and use it in place of LOCAL_REPO.  
Replace MY_USERNAME as branch name with the part of your @aggies.ncat.edu email 
before the @ sign. (E.g. for defoulser@aggies.ncat.edu --> Replace MY_USERNAME with dfoulser).  Make sure this is one
of the branches in the menu of branches at lower left in the image.

* cd ~
* git clone REMOTE_URL
* cd LOCAL_REPO
* git checkout -b MY_USERNAME

# Make changes on your individual branch

Make sure you are in the local repo directory and using your branch.  Use git add and git commit -m "" commands
to make changes to your branch.

# Push changes to the remote repo.

Issue the following command when in the local repo.

* git push REMOTE_REPO

Now take the following actions:

* On GitHub at the URL of the remote repo, click on the PullRequests tab at top of page.  
* Then click "New Pull Request" button to create a new Pull-Request.  
* Fill out the fields and submit the pull-request (use branch <-- master)
* Ask your team member(s) to approve the pull-request.
* You or your team member(s) click the merge button (to merge the pull-request commit into master)

# Pull changes from the remote repo.

After merging your changes into master in the remote repo, do the following to update locally.

* git checkout master
* git pull
* git checkout MY_USERNAME 
* git merge master
* git commit -m "put your message here"
