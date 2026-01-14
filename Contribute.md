# 🤝 Contributing to Spring Security JWT Project

Thank you for considering contributing to this project! 🎉  
Your help is greatly appreciated — whether it’s fixing bugs, improving documentation, or adding new features.

---

## 🧭 Contribution Guidelines

Please take a moment to review this guide to make the contribution process smooth and effective.

### 1. Fork the Repository

Start by **forking** this repository to your own GitHub account:

```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
Then, add the original repo as a remote to stay updated:

bash
Copy code
git remote add upstream https://github.com/<original-author-username>/<repo-name>.git
2. Create a New Branch
Create a feature branch for your work:

bash
Copy code
git checkout -b feature/your-feature-name
Examples:

feature/add-role-based-access

bugfix/jwt-expiration-issue

3. Make Your Changes
Follow clean code practices.

Keep the code consistent with existing formatting.

Ensure meaningful commit messages (see below).

If you add new functionality, include tests if possible.

4. Commit Your Changes
Write clear, descriptive commit messages:

bash
Copy code
git commit -m "Add JWT filter for authentication"
Examples of good commit messages:

Fix: corrected JWT token expiration issue

Feat: added refresh token endpoint

Docs: improved README with setup steps

5. Sync With Main Branch
Before submitting a Pull Request, make sure your branch is up to date:

bash
Copy code
git fetch upstream
git merge upstream/main
Resolve any conflicts if needed.

6. Submit a Pull Request (PR)
Push your branch to your fork:

bash
Copy code
git push origin feature/your-feature-name
Then go to GitHub and open a Pull Request against the main branch.
Provide a clear description of what your PR does and any relevant details or screenshots.

🧠 Code Style
Please follow these conventions:

Java 17+

Use Lombok for boilerplate reduction

Follow Spring naming conventions (Controller, Service, Repository)
Keep code clean and well-commented

🧩 Areas You Can Contribute To
🐛 Fix bugs

🧰 Improve error handling or logging

✨ Add new authentication or role-based features

🧪 Add tests (unit/integration)

🧾 Improve documentation (README, API docs)

🚀 Optimize performance or security
