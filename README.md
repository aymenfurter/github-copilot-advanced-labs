# 🚀 GitHub Copilot Advanced Labs

> **Hands-on labs designed to demonstrate advanced GitHub Copilot capabilities across different development scenarios**

[![GitHub Copilot](https://img.shields.io/badge/GitHub-Copilot-blue?logo=github)](https://github.com/features/copilot)
[![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)](https://www.oracle.com/java/)
[![Kubernetes](https://img.shields.io/badge/Kubernetes-v1.22+-blue?logo=kubernetes)](https://kubernetes.io/)
[![Docker](https://img.shields.io/badge/Docker-latest-blue?logo=docker)](https://www.docker.com/)

---

## 📋 Labs Overview

| Lab | Title | Description |
|-----|-------|-------------|
| **[Lab 0](./lab0-multi-file-edit/)** | Calculator App Development (Copilot Edits) | Develop a calculator app by first implementing the entire functionality in a single HTML file. Then refactoring it into separate HTML, CSS, and JavaScript files for improved maintainability. |
| **[Lab 1](./lab1-broken-tests/)** | Fixing Broken Tests (Agent Mode) | A Java project with intentionally broken test cases that fail due to bugs in the implementation. This lab demonstrates GitHub Copilot's Agent Mode which can run commands and fix code autonomously. **Key Skills:** Using GitHub Copilot to identify and fix multiple bugs, Experiencing how Copilot can run tests and make incremental improvements, Learning effective prompting strategies for debugging |
| **[Lab 2](./lab2-k8s-troubleshooting/)** | Kubernetes Deployment Troubleshooting (Agent Mode) | A set of Kubernetes deployment manifests containing various issues including incorrect configurations, linting problems, and security vulnerabilities in an outdated nginx image. This lab demonstrates how GitHub Copilot's Agent Mode can identify and fix deployment problems, run linting tools, and address security concerns. **Key Skills:** Using GitHub Copilot to debug and fix Kubernetes deployment manifests, Leveraging kubeconform linting tool with Copilot to identify and resolve deployment issues, Identifying security vulnerabilities in container images and applying fixes, Experiencing Copilot's ability to run commands to validate, rebuild, and verify fixes. **Tools Used:** kube-linter for Kubernetes manifest validation, Container security scanning tools, kubectl for deployment verification |
| **[Lab 3](./lab3-legacy-java-app/)** | Modernize Legacy Java App | ```copilot> Please modernize lab3-legacy-java-app to be a modern java spring boot app. make sure to first give me a plan I can approve. Create a new dire that is lab3-modern-java-app as a result. Includje and run also tests.``` |
| **[Lab 4](./lab4-mcp/)** | MCP | A lab focused on using the Model Context Protocol (MCP) to interact with GitHub and other tools. This replaces the previous GitHub Copilot Workspace lab. |
| **[Lab 5](./lab5-ai-sdlc/)** | Software Development Lifecycle using GitHub Copilot | |
| **[Lab 6](./lab6-customization/)** | Customizing GitHub Copilot Chat Responses | Learn how to customize GitHub Copilot Chat responses to fit your team's preferences, coding practices, and project requirements. |
| **[Lab 7](./lab7-coding-agent/)** | GitHub Copilot Coding Agent | Learn how to use GitHub Copilot Coding Agent to automatically work on GitHub issues. Create well-scoped issues for documentation, accessibility fixes, and unit testing, then assign them to Copilot to see autonomous development in action. **Key Skills:** Creating effective issue descriptions for AI agents, Monitoring agent progress and reviewing generated pull requests, Understanding best practices for human-AI collaboration in development workflows |

---

## 🎯 Learning Objectives

By completing these labs, you will:

- ✅ Master GitHub Copilot's various modes (Chat, Edits, Agent)
- ✅ Learn effective prompting strategies for different scenarios
- ✅ Experience AI-assisted debugging and troubleshooting
- ✅ Understand how to integrate Copilot into your development workflow
- ✅ Gain hands-on experience with modern development practices
- ✅ Learn to customize Copilot for team-specific requirements
- ✅ Experience autonomous development with GitHub Copilot Coding Agent

---

## 📚 Prerequisites

- **GitHub Copilot subscription** (Individual, Business, or Enterprise)
- **Visual Studio Code** with GitHub Copilot extension
- **Basic programming knowledge** in Java, JavaScript, or Python
- **Git** for version control operations
- **Docker** and **kubectl** (for Kubernetes labs)
