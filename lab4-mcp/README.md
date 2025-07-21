# Lab 4: Model Context Protocol (MCP) with Azure DevOps (25-30 min)

This lab demonstrates how to use the Model Context Protocol (MCP) to integrate GitHub Copilot with Azure DevOps.

## Overview

The Model Context Protocol (MCP) allows GitHub Copilot to connect with external systems and services. In this lab, you'll:

1. Configure MCP to connect with Azure DevOps
2. List and search existing work items
3. Create new work items using natural language

## Exercise 1: Setting Up MCP with Azure DevOps (10 mins)

### Step 1: Create Azure DevOps Personal Access Token

1. Go to your Azure DevOps organization
2. Navigate to User Settings → Personal Access Tokens
3. Create a new token with the following permissions:
   - Work Items: Read & Write
   - Projects: Read

### Step 2: Configure MCP

1. **Create MCP configuration file:**
   - Create or update your MCP configuration (.vscode/mcp.json) with the Azure DevOps server 

```json
{
    "inputs": [
        {
            "type": "promptString",
            "id": "ado_pat",
            "description": "Azure DevOps Personal Access Token",
            "password": true,
            "default": ""
        },
        {
            "type": "promptString",
            "id": "ado_org",
            "description": "Azure DevOps Organization URL",
            "default": "https://dev.azure.com/your-org"
        },
        {
            "type": "promptString",
            "id": "ado_project",
            "description": "Azure DevOps Project Name",
            "default": "your-project-name"
        }
    ],
    "servers": {
        "azuredevops": {
            "command": "docker",
            "args": [
                "run",
                "-i",
                "--rm",
                "-e",
                "ADO_PERSONAL_ACCESS_TOKEN",
                "-e",
                "ADO_ORGANIZATION_URL",
                "-e",
                "ADO_PROJECT_NAME",
                "ado-mcp-server"
            ],
            "env": {
                "ADO_PERSONAL_ACCESS_TOKEN": "${input:ado_pat}",
                "ADO_ORGANIZATION_URL": "${input:ado_org}",
                "ADO_PROJECT_NAME": "${input:ado_project}"
            }
        }
    }
}
```

## Exercise 2: Listing and Searching Work Items

### List All Work Items

```
copilot>
List all work items.
```
## Exercise 3: Creating New Work Items 

### Create a Task Work Item

```
copilot>
Create a new task work item titled "Login page not responsive on mobile devices" with description "The login form elements are not properly aligned on mobile screens below 768px width."
```

---

## Additional Resources

- [Official Azure DevOps MCP Server](https://github.com/microsoft/azure-devops-mcp) - Microsoft's official MCP implementation
- [Sample ADO MCP Server](https://github.com/aymenfurter/ado-mcp-server-python) - Simplified demo implementation with only reduced tools (used in this lab for educational purposes)
- [Model Context Protocol Documentation](https://modelcontextprotocol.io/) - Official MCP specification
- [Azure DevOps REST API](https://docs.microsoft.com/en-us/rest/api/azure/devops/) - API reference for advanced integrations

---

## Success Criteria

✅ MCP is configured and connected to Azure DevOps  
✅ Can list work items effectively  