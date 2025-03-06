# GitHub Copilot Advanced Labs

This repository contains three hands-on labs designed to demonstrate advanced GitHub Copilot capabilities.

## Labs Overview

### Lab 0: Calculator App Development (Copilot Edits)
Develop a calculator app by first implementing the entire functionality in a single HTML file—and then refactoring it into separate HTML, CSS, and JavaScript files for improved maintainability.

[Go to Lab 0](./lab0-multi-file-edit/)

### Lab 1: Fixing Broken Tests (Agent Mode)
A Java project with intentionally broken test cases that fail due to bugs in the implementation. This lab demonstrates GitHub Copilot's Agent Mode which can run commands and fix code autonomously.

**Key Skills:**
- Using GitHub Copilot to identify and fix multiple bugs
- Experiencing how Copilot can run tests and make incremental improvements
- Learning effective prompting strategies for debugging

[Go to Lab 1](./lab1-broken-tests)

### Lab 2: Kubernetes Deployment Troubleshooting (Agent Mode)
A set of Kubernetes deployment manifests containing various issues including incorrect configurations, linting problems, and security vulnerabilities in an outdated nginx image. This lab demonstrates how GitHub Copilot's Agent Mode can identify and fix deployment problems, run linting tools, and address security concerns.

**Key Skills:**
- Using GitHub Copilot to debug and fix Kubernetes deployment manifests
- Leveraging kubeconform linting tool with Copilot to identify and resolve deployment issues
- Identifying security vulnerabilities in container images and applying fixes
- Experiencing Copilot's ability to run commands to validate, rebuild, and verify fixes

**Tools Used:**
- kube-linter for Kubernetes manifest validation
- Container security scanning tools
- kubectl for deployment verification

[Go to Lab 2](./lab2-k8s-troubleshooting)

### Lab 3: Modernize Legacy Java App

[Go to Lab 3](./lab3-legacy-java-app/)

### Lab 4: GitHub Copilot Workspace 
Containerize an existing Application

[Go to Lab 3](./lab3-github-workspace)
