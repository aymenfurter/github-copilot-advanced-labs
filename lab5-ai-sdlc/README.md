# Lab 5: A Day in the SDLC with GitHub Copilot (20-25 min Demo)
In this lab, we'll follow a single feature (submitting an insurance claim) through the software development lifecycle, showcasing how GitHub Copilot enhances each phase for a Python application.

**SDLC Phases Covered:**
1. Requirements Engineering (User Story with Acceptance Criteria)
2. Design
3. Implementation
4. Testing
5. Code Review (GitHub Copilot for Pull Requests)
6. Deployment
7. Maintenance

---
## Basic Functionality of Copilot

1) open helloworld.py
2) Show autocompletion and in-line chat.

## Chat Intro

"What are the phases of the SDLC process?" 
"#codebase where is my MCP configured?"
"#terminalSelection what do you think of my machine?"
"What is an MCP server?"
"@github check web for What is an MCP server?"

## 1. Requirements Engineering (3 mins)

### Draft a User Story 
**Copilot Chat (VSCode):**

"Give me the draft of a user story for an API endpoint and Form for auto insurance claims with: policy_id (format: INS-XXX-XXX), incident_date (ISO 8601), incident_time (24h format), description (min 50 chars)."

### Define Definition of Done (Attempt 1)
**Copilot Chat (VSCode):**

"Update the user story with acceptance criteria based on the team's DoD from https://gist.github.com/aymenfurter/bf4cc602e5e45ce57b3c5138bd49e1c5"

### Create a work item on ADO
**Copilot Chat (VSCode):**

"OK - Now please create a work item of type Issue in Azure DevOps for this user story."

---

## 2. Design (3 mins)

### Generate HTML Prototype
**Copilot Chat:**

"OK - Let's implement this user story. Start by generating a prototype form with for submitting the insurance claim as per the user story. Use the screenshot as a reference for the layout, font style and design."


### Edit Form Component
**Open Simple Browser: Show. Then click on 'Add element to chat'. Then enter in  Copilot Chat:**
 
"Make the button bigger and easier to read. Make sure the text labels are consistent in font style and color."

### Design Architecture
**Azure Copilot Extension + Copilot Chat:**

"Use Azure Docs to compare Azure Service Bus Queue vs Event Grid for processing sequential insurance claims, focusing on reliability and ordered delivery. Which would be a better fit for implementing this user story?"

"OK - Please edit the work item in Azure DevOps to reflect this design decision."

### Visualize 
**Mermaid Chart Extension + Copilot Chat:**

"Visualize the exchange between the Web Frontend, Python Backend and Service Bus using Mermaid."

"Add more detail on the Service Bus aspects"

### Design API Endpoint
**Copilot Chat:**

"Design a OpenAPI Specification for a POST endpoint for /claims that accepts and validates a Claim object, returning a claim reference number."

"Please perform lint validation this OpenAPI Specification using spectral. Validate against the following ruleset: https://gist.githubusercontent.com/aymenfurter/9140b60b2aa57774fd6b84af2bce9725/raw/1710fd04e31f8bf1d90caea0d218f7b6a90bc465/ruleset.yaml"

"Please fix all findnigs and revalidate"

---

## 3. Implementation (5 mins)

### Generate API Boilerplate Code
**Copilot Chat:**

"Commit and publish to private repo"

"Give me the boilerplate code for main.py validate_request.py and requirements.txt to implement this user story. Return a static response for now."

## 4. Testing (3 mins)

### API Testing Setup
**Copilot Chat:**

"/tests"

---

## 5. Code Review (3 mins)

### Create Pull Request
git add .
git commit -m "inital"
git push origin main:initial

VSCode: The developer creates a Pull Request (PR) with the changes.

Terminal:
git push origin main:feat2

### GitHub Copilot for Pull Requests
**Automated Analysis:**
- GitHub Copilot automatically analyzes the PR
- Provides a **summary** of the changes (e.g., 'Adds a /claims endpoint using FastAPI, sends data to Service Bus, includes tests')
- Suggests improvements based on code patterns or missing validation
- Helps reviewers make faster, more informed decisions



---

(Below here is optional)

## 6. Deployment (3 mins)

### Generate Infrastructure as Code
**Copilot Chat:**

"Create a YAML pipeline to deploy this app into Azure App Service. Adhere to best practices documented here: https://learn.microsoft.com/en-us/azure/devops/pipelines/process/templates?view=azure-devops&pivots=templates-includes"

---

## 7. Maintenance (2 mins)

### Generate Documentation
**Copilto Chat**

#codebase create a readme file

### Code Understanding
**Copilot Ask Chat:**

'Explain this code'
