# Lab 7: GitHub Copilot Coding Agent (20 min)

This lab teaches you how to use GitHub Copilot Coding Agent to automatically work on GitHub issues using a sample repository.

## Overview

GitHub Copilot Coding Agent can work like a human developer - you assign it GitHub issues, it creates pull requests, and you review the work.

---

## Setup: Fork the Sample Repository (2 mins)

1. **Fork the sample repository:**
   - Go to: https://github.com/aymenfurter/github-labs-coding-agent/
   - Click "Fork" to create your own copy
   - Clone your fork locally

2. **Verify the repository structure:**
   - `app.py` - Simple Flask web application
   - `static/` - CSS and JavaScript files
   - `templates/` - HTML templates
   - No README file yet!
   - No unit tests yet!

---

## Exercise 1: Create Issue #1 - Add README File (5 mins)

### Create a Well-Scoped Issue

**Create a new GitHub issue:**

```markdown
Title: Add comprehensive README file for the project

## Problem
The repository lacks documentation, making it difficult for new contributors to understand the project and get started.

## Acceptance Criteria
- [ ] Create a comprehensive README.md file
- [ ] Include project description and purpose
- [ ] Add installation and setup instructions
- [ ] Document how to run the application
- [ ] Include usage examples and screenshots
- [ ] Add contribution guidelines
- [ ] Include license information

## Files to Change
- Create `README.md` in the root directory

## Additional Context
- This is a Flask web application with a simple interface
- Include Python version requirements
- Document any dependencies from requirements.txt
- Follow Agile principles and make documentation clear and user-friendly
```

### Assign to Copilot

1. **Assign the issue:**
   - Click "Assignees" in the right sidebar
   - Select "Copilot" from the list
   - Watch for the 👀 reaction from Copilot

---

## Exercise 2: Create Issue #2 - Fix UI Contrast Issues (5 mins)

### Create a Contrast Accessibility Issue

**Create a new GitHub issue:**

```markdown
Title: Fix contrast issues in user interface for accessibility compliance

## Problem
The current user interface has poor color contrast that doesn't meet accessibility standards, making it difficult for users with visual impairments to read content.

## Acceptance Criteria
- [ ] Audit all text/background color combinations
- [ ] Ensure contrast ratios meet WCAG 2.1 AA standards (4.5:1 for normal text)
- [ ] Fix low contrast issues in CSS files
- [ ] Maintain the current design aesthetic while improving accessibility
- [ ] Test with accessibility tools to verify improvements

## Files to Change
- `static/style.css` or other CSS files
- Any inline styles in HTML templates if needed

## Additional Context
- Follow WCAG 2.1 accessibility guidelines
- Use tools like WebAIM contrast checker for validation
- Ensure the fix works across different browsers
- Maintain visual hierarchy and design consistency
```

### Assign to Copilot

1. **Assign this second issue to Copilot**
2. **Monitor progress in the Actions → Agents tab**

---

## Exercise 3: Create Issue #3 - Add Unit Tests (5 mins)

### Create a Testing Issue

**Create a new GitHub issue:**

```markdown
Title: Add comprehensive unit tests for the Python Flask application

## Problem
The Flask application (app.py) has no unit tests, making it risky to modify and deploy changes without proper validation.

## Acceptance Criteria
- [ ] Add unit tests for all Flask routes and functions
- [ ] Test both successful responses and error cases
- [ ] Achieve high code coverage (aim for 90%+)
- [ ] Use pytest framework following Python best practices
- [ ] Add test configuration and requirements
- [ ] Include instructions for running tests

## Files to Change
- Create `test_app.py` with comprehensive test cases
- Update `requirements.txt` with testing dependencies
- Ensure all functions in `app.py` are tested

## Additional Context
- Use pytest fixtures for test setup
- Test HTTP status codes and response content
- Mock external dependencies if any
- Follow Agile testing principles and best practices
- Include edge cases and error scenarios
```

### Assign to Copilot

1. **Assign this third issue to Copilot**

---

## Exercise 4: Monitor and Review (3 mins)

### Track All Sessions

1. **Monitor progress:**
   - Navigate to repository → Actions → Agents tab
   - View all active and completed sessions
   - Click "View session" to see detailed progress

### Review Pull Requests

1. **For each completed PR:**
   - Review the code changes
   - Test the functionality
   - Add review comments if improvements needed

**Example review comments:**

```markdown
For README PR:
- Include Python version requirements

For Contrast PR:
- Test on both light and dark browser themes
- Include a screenshot of the updated UI

For Testing PR:
- Add test cases for invalid input scenarios
- Include coverage report generation
```

---

## Success Criteria

✅ Successfully forked and set up the sample repository  
✅ Created 3 well-scoped issues following Agile principles  
✅ All issues assigned to Copilot successfully  
✅ Copilot created pull requests for each issue  
✅ Reviewed and provided feedback on the generated code  
✅ Understanding of how to effectively collaborate with coding agents