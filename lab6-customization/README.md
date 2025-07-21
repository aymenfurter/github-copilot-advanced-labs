# Lab 6: Customizing GitHub Copilot

This lab teaches you how to customize GitHub Copilot Chat responses to fit your team's preferences, coding practices, and project requirements using custom instructions, prompt files, and custom chat modes.

## Overview

Instead of repeatedly adding contextual information to every chat prompt, you can create files that automatically provide this context. This lab covers three main customization approaches:

1. **Custom Instructions** - Repository-wide guidelines that apply to all conversations
2. **Prompt Files** - Reusable prompts for common **tasks**
3. **Custom Chat Modes** - Define chat **behavior**, available **tools**, and **interaction patterns**

> 💡 **Additional Resources**: For more examples and community-contributed customizations, visit the [Awesome GitHub Copilot](https://github.com/github/awesome-copilot) repository which contains a comprehensive collection of custom instructions, prompts, and chat modes.


## Exercise 1: Custom Instructions (10 mins)

### Create cross repo-custom instructions via settings

Custom instructions via settings ('github.copilot.chat.codeGeneration.instructions') apply to all repositories across workspaces. This is useful for setting global coding standards or practices (or to allow copilot get to know you).

### Create a Repository Custom Instructions File

Custom instructions provide repository-wide context that automatically applies to all Copilot interactions in your workspace. This is useful since we can set coding standards, preferred libraries, and other guidelines that Copilot will follow when generating code. We can version control this file together with our codebase.

**Create a .github/copilot-instructions.md file for our web application project with instructions for: In this project, we are using Agile methodology to manage our development process. Ensure any work items or tasks you create are well-defined and follow the Agile principles.**

**Test the custom instructions:**

```
copilot> 
Create a work item for managing user authentication
```

### Success Criteria
✅ Custom instructions file created  
✅ Generated user story follows the specified guidelines  
✅ Instructions appear in References section

---

## Exercise 2: Prompt Files for Reusable Tasks (10 mins)

### Create Common Prompt Files

**Create the following prompt files in `.github/prompts/`:**

1. **Create `user-story.prompt.md`:**

You will be given a feedback of a user. Based on that, please create a user story following Agile best practices. Include acceptance criteria, definition of done, and story points estimation guidance. Focus on common application features like login, registration, and user management.
   - Generate user stories following Agile best practices
   - Include acceptance criteria
   - Follow "As a [user], I want [goal] so that [benefit]" format
   - Include definition of done
   - Add story points estimation guidance
   - Focus on common application features (login, registration, user management, etc.)

Use the following fictive user feedback as an example:
- Feedback 1: I opened the application and tried to register a new account. The registration form was easy to use, but I would like to have an option to sign up using my Google account. After registering, I want to be able to log in with my email and password. It would also be great if I could reset my password if I forget it.
- Feedback 2: I logged in successfully, but I noticed that the user profile page is missing. I want to be able to view and edit my profile information, such as my name, email, and password. It would also be helpful to have a section for managing my account settings, like notification preferences.
- Feedback 3: I want to be able to log out of the application easily. After logging out, I should be redirected to the login page. It would also be nice to have a confirmation message when I log out, just to make sure I did it successfully.

### Use Prompt Files

**Test the React component prompt:**

```
copilot> 
/react-component: Create a LoginForm component that handles user authentication
```

**Test the user story prompt:**

```
copilot> 
/user-story: Create user stories based on the user feedback.
```

### Success Criteria
✅ prompt file are created  
✅ Prompt files can be executed using / syntax  
✅ Generated content follows prompt specifications

---

## Exercise 3: Custom Chat Modes - Backlog Grooming (10 mins)

### Create Custom Chat Mode

**Create the following custom chat mode file in `.github/copilot/`:**

**Create `scrum-master.chat.md`:**
```markdown
---
description: 'Description of the custom chat mode.'
tools: ['azuredevops']
---
- Act as experienced Scrum Master
- List and review existing work items
- Provide feedback on what should be improved
- Make proposals for improvements
- Please format your output as tables.
- Create new work items for identified improvements - but gather user confirmation first.
```

**Test Scrum Master mode:**
- A "Review our current work items and suggest improvements"
- Follow up: "Create work items for the improvements you identified"

### Success Criteria
✅ Scrum master chat mode created  
✅ Mode reviews existing work items
✅ Mode provides improvement feedback
✅ Mode creates new improvement work items - but gathers user confirmation first.