# Elder Care Investment Platform — UML Use Case Diagrams (PlantUML)

This package contains 9 PlantUML files, split by subsystem instead of one
giant diagram. This avoids the crossed-line clutter you get when PlantUML's
auto-layout tries to place 30+ use cases on a single canvas.

## Files

| File | Contents |
|---|---|
| `00_context_diagram.puml` | All 7 actors + 8 subsystem boundaries (no individual use cases) — the big picture |
| `01_account_access.puml` | Register, Login, Manage Profile, Verify Identity, Authenticate User |
| `02_investment_management.puml` | Browse/Select Plans, Make Contribution, Monitor Portfolio, Growth Report |
| `03_facility_reservation.puml` | Browse Facilities, Reserve/Cancel Reservation |
| `04_health_records.puml` | Manage/Update/Share Health Records, View Dependent Records |
| `05_payments.puml` | Make/Process Payment, Payment History, Generate Invoice |
| `06_communication.puml` | Communicate with Facility Manager, Send Message, Respond to Inquiry, Send Notification |
| `07_guardian_services.puml` | Manage Dependent's Investment, Reserve for Dependent, View Dependent Health |
| `08_administration.puml` | Manage Users/Plans/Facilities/Reservations/Payments, Generate Reports |

Notes in a few diagrams (e.g. `02_investment_management.puml`) point to a
use case that's fully defined in another file — this is how you represent a
shared `<<include>>` target (like "Process Payment") without duplicating an
entire subsystem across files.

## How to render these into images

### Option A — Online (fastest, no install)
1. Go to https://www.plantuml.com/plantuml
2. Paste the contents of any `.puml` file
3. Click Submit — the diagram renders instantly
4. Right-click the image → Save As
(Don't paste confidential data into the public server.)

### Option B — VS Code (recommended)
1. Install **VS Code**
2. Install the **"PlantUML"** extension (publisher: jebbs)
3. Install **Java** and **Graphviz** (required by the renderer):
   - Windows: `choco install graphviz`
   - Mac: `brew install graphviz`
   - Linux: `sudo apt install graphviz`
4. Open any `.puml` file, press `Alt+D` (or `Cmd+Option+D` on Mac) to preview
5. Right-click the preview → **Export Current Diagram** → PNG / SVG / PDF

### Option C — Command line (batch export all files at once)
```bash
# Install
brew install plantuml        # Mac
choco install plantuml       # Windows
sudo apt install plantuml    # Linux

# Render every .puml file in this folder to PNG
plantuml *.puml

# Or SVG (sharper, better for reports/documents)
plantuml -tsvg *.puml
```

## Assembling into one document (Word/PowerPoint/PDF)

1. Render each `.puml` file to PNG/SVG using one of the options above.
2. Place `00_context_diagram` first as the overview page.
3. Follow with one subsystem diagram per page/slide, in numeric order.
4. Optionally add a one-paragraph description above each diagram explaining
   which actors and include/extend relationships it covers (see the
   original response text for descriptions of each).

This structure — one context diagram + focused subsystem diagrams — is the
standard way enterprise architecture documentation handles systems too large
for a single readable use case diagram.
