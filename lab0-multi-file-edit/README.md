# Lab 0: Calculator App Development (Copilot Edits)

## Phase 1: All-in-One File

In the first phase, you will create a single HTML file that includes:
  
1. **HTML Structure** for the Calculator UI
2. **Embedded CSS** for styling the calculator
3. **Inline JavaScript** to implement the calculator logic

### Exercise

- Create an `index.html` file housing your complete Calculator App.
- Implement basic arithmetic operations (addition, subtraction, multiplication, division).

```
copilot> 
Please build the Calculator App inside index.html integrating HTML, CSS, and JavaScript.
```

## Phase 2: Code Refactoring

After validating your single file app, refactor your code by separating concerns into different files:

1. **HTML**: Retain the structure in `index.html`.
2. **CSS**: Move styles to `css/styles.css`.
3. **JavaScript**: Place all script logic in `js/app.js`.

### Exercise

- Create the folder structure and files:
  - `/css/styles.css`
  - `/js/app.js`
  - Update `/index.html` to link both external CSS and JavaScript files.
- Verify that the Calculator App continues to function as expected.

```
copilot> 
Refactor the project into three files and ensure all functionalities work without errors.
```

## Phase 3: Visual Enhancement with GPT-4o

In this phase, you'll use GPT-4o's multi-modal capabilities through GitHub Copilot in VS Code Insiders to improve the calculator's design:

1. **Screenshot Preparation**
   - Open your calculator in a browser
   - Take a screenshot of your current calculator interface
   - Save it as `calculator-current.png`

2. **Visual AI Consultation**
   - Open VS Code Insiders, navigate to Copilot Chat
   - Drag and drop your `calculator-current.png`
   - Ask GPT-4o to suggest visual improvements for:
     - Color scheme
     - Layout
     - Typography

3. **Implementation**
   - Apply the AI-suggested visual enhancements to your CSS

### Exercise

- Capture your calculator's current state
- Use GPT-4o to analyze and get suggestions
- Implement the visual improvements

```
copilot> 
Analyze my calculator design and suggest visual improvements that follow modern UI principles.
```

## Success Criteria

✅ The Calculator App performs all arithmetic operations correctly  
✅ The merged code from individual files works seamlessly  
✅ The refactored project exhibits a clear separation of responsibilities  
✅ The UI incorporates modern design principles suggested by GPT-4o