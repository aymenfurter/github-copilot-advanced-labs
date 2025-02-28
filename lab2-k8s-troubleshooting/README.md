# Lab 2: Kubernetes Deployment Troubleshooting

This lab demonstrates how GitHub Copilot's Agent Mode can help identify and fix issues in Kubernetes deployment manifests. You'll work with deployments that have various problems including configuration errors, linting issues, and security vulnerabilities.

## Prerequisites

- Docker installed
- kubectl installed 
- Azure CLI installed (for AKS setup)
- Azure subscription with permissions to enable Microsoft Defender for Containers


## Exercises

### Exercise 1: Fix the Incorrect Deployment (Agent Mode)

The `incorrect-deployment.yaml` has several configuration issues. Use GitHub Copilot Agent Mode to:

1. Identify the issues in the deployment manifest
2. Fix the issues to make the deployment valid
3. Verify the fixes using kubectl

```
copilot> 
Please help me fix the issues in the incorrect-deployment.yaml file so it can be successfully deployed #terminalLastCommand 
```

### Exercise 2: Resolve Linting Issues (Agent Mode)
i
The `linting-deployment.yaml` contains issues that can be detected by "kube-linter lint". Use GitHub Copilot Agent Mode to:

1. Run kube-linter to identify linting issues
2. Fix the identified issues
3. Verify the fixes pass kubeconform validation

```
copilot> 
Review linting-deployment.yaml using the "kube-linter lint" and fix any issues it finds.  

copilot> 
Implement any security best practies that are missing.
```

### Exercise 3: Address Security Vulnerabilities (Copilot Chat with @github)

1. Scan the image for vulnerabilities using Microsoft Defender for Containers
2. Update the nginx image to a secure version
3. Fix security misconfigurations in the deployment
4. Rebuild the container image if necessary
5. Verify the security improvements

```
copilot> 
Azure Container Registry warns me that I have open CVEs (CVE-2020-36329, CVE-2020-36328, CVE-2018-25014, CVE-2018-25013, CVE-2018-25012, etc) - What could be the reason?

copilot> 
@github 1.21.6 seems to be an older version too. Please tell me the most recent nginx version number?
```

## Success Criteria

✅ All deployments can be successfully applied with kubectl  
✅ kubeconform passes without errors on all deployment files  
✅ Security vulnerabilities are addressed and verified with Microsoft Defender for Containers

## Environment Setup

### Setting up Azure Kubernetes Service (AKS)

Before starting the exercises, you'll need a Kubernetes cluster to deploy your applications. Follow these steps to set up an AKS cluster:

1. **Login to Azure**
   ```bash
   az login
   ```

2. **Create a resource group**
   ```bash
   az group create --name copilot-lab-rg --location switzerlandnorth 
   ```

3. **Create an AKS cluster**
   ```bash
   az aks create \
     --resource-group copilot-lab-rg \
     --name copilot-lab-cluster \
     --node-count 2 \
     --enable-addons monitoring \
     --generate-ssh-keys
   ```

4. **Connect to the cluster**
   ```bash
   az aks get-credentials --resource-group copilot-lab-rg --name copilot-lab-cluster
   ```

5. **Verify connection**
   ```bash
   kubectl get nodes
   ```

### Setting up Microsoft Defender for Containers

Enable Microsoft Defender for Containers to scan for vulnerabilities:

1. **Enable Microsoft Defender for Cloud**
   ```bash
   az security pricing create -n containers --tier standard
   ```

2. **Enable Container Registry scanning**
   ```bash
   az provider register --namespace Microsoft.ContainerService
   az provider register --namespace Microsoft.Security
   ```

3. **Configure Azure Container Registry (ACR) for image scanning**
   ```bash
   az acr create --resource-group copilot-lab-rg --name copilotlabacr --sku Standard
   az acr login --name copilotlabacr
   ```

4. **Build and push the Docker image for scanning**
   ```bash
   docker build -t copilotlabacr.azurecr.io/nginx-security:1.14.0 -f Dockerfile .
   docker push copilotlabacr.azurecr.io/nginx-security:1.14.0
   ```

5. **Connect ACR to AKS**
   ```bash
   az aks update -n copilot-lab-cluster -g copilot-lab-rg --attach-acr copilotlabacr
   ```

## Lab Overview

In this lab, you'll find three Kubernetes deployment files with different issues:

1. **incorrect-deployment.yaml**: Contains configuration errors that prevent successful deployment
2. **linting-deployment.yaml**: Contains issues that can be identified using kubeconform
3. **security-deployment.yaml**: Contains security vulnerabilities in the container image and configuration
