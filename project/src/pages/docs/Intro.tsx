import { Card } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Link } from "react-router-dom";
import { ArrowRight, Zap, Shield, Code } from "lucide-react";
import { useState } from "react";

export default function Intro() {
  const [activeTab, setActiveTab] = useState("javascript");
  return (
    <div className="space-y-8">
      <div className="space-y-4">
        <h1 className="text-4xl font-bold font-dm-serif text-foreground">
          Introduction
        </h1>
        <p className="text-xl text-muted-foreground leading-relaxed">
          Welcome to the Dreamcatcher API documentation, a modern and powerful
          REST API that allows you to explore the musical universe of the South
          Korean group Dreamcatcher.
        </p>
      </div>

      <div className="grid md:grid-cols-3 gap-6">
        <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
          <div className="flex items-center space-x-2 mb-4">
            <Zap className="h-6 w-6 text-mystery-blue" />
            <h3 className="text-lg font-semibold">Fast and Efficient</h3>
          </div>
          <p className="text-muted-foreground">
            Built with Java and Spring Boot for maximum performance and
            scalability.
          </p>
        </Card>

        <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
          <div className="flex items-center space-x-2 mb-4">
            <Shield className="h-6 w-6 text-mystery-blue" />
            <h3 className="text-lg font-semibold">Reliable</h3>
          </div>
          <p className="text-muted-foreground">
            Updated and verified data about Dreamcatcher and their history as
            Minx.
          </p>
        </Card>

        <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
          <div className="flex items-center space-x-2 mb-4">
            <Code className="h-6 w-6 text-mystery-blue" />
            <h3 className="text-lg font-semibold">Easy to Use</h3>
          </div>
          <p className="text-muted-foreground">
            Standard REST API with clear JSON responses and complete
            documentation.
          </p>
        </Card>
      </div>

      <Card className="p-6 bg-gradient-mysterious text-white border-mystery-accent/20">
        <h2 className="text-2xl font-semibold mb-4 font-dm-serif">
          What can you do?
        </h2>
        <ul className="space-y-2 text-white/90">
          <li>• Get detailed information about all Dreamcatcher members</li>
          <li>• Search for specific members by their stage name</li>
          <li>• Explore the complete discography of the group</li>
          <li>• Access songs organized by album</li>
          <li>• Learn about the history of Minx, the predecessor group</li>
        </ul>
      </Card>

      <div className="space-y-4">
        <h2 className="text-2xl font-semibold font-dm-serif">Base URL</h2>
        <Card className="p-4 bg-muted/50">
          <code className="text-white/90 font-mono text-lg">
            https://dreamcatcherapi.onrender.com
          </code>
        </Card>
      </div>

      <div className="space-y-4">
        <h2 className="text-2xl font-semibold font-dm-serif">Quick Example</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <p className="text-muted-foreground mb-4">
            Get information about all members:
          </p>

          {/* Tabs for different languages */}
          <div className="flex border-b border-gray-800 mb-4">
            <button
              className={`px-4 py-2 ${
                activeTab === "javascript"
                  ? "bg-gray-900 text-white font-medium"
                  : "bg-transparent text-gray-400"
              }`}
              onClick={() => setActiveTab("javascript")}
            >
              JavaScript
            </button>
            <button
              className={`px-4 py-2 ${
                activeTab === "python"
                  ? "bg-gray-900 text-white font-medium"
                  : "bg-transparent text-gray-400"
              }`}
              onClick={() => setActiveTab("python")}
            >
              Python
            </button>
            <button
              className={`px-4 py-2 ${
                activeTab === "curl"
                  ? "bg-gray-900 text-white font-medium"
                  : "bg-transparent text-gray-400"
              }`}
              onClick={() => setActiveTab("curl")}
            >
              cURL
            </button>
          </div>

          <div className="bg-mystery-darker p-0 rounded-lg">
          {/* Código de ejemplo - JavaScript */}
          {activeTab === "javascript" && (
            <div className="bg-gray-900 p-6">
              <pre className="text-sm leading-relaxed">
                {`const response = await fetch("https://dreamcatcher-api.com/members");

const data = await response.json();

console.log(data);

const members = data.members;
members.forEach(member => {
console.log(\`\${member.stage_name}: \${member.name}\`);
                });`}
              </pre>
            </div>
          )}
          {/* Código de ejemplo - Python */}
          {activeTab === "python" && (
            <div className="bg-gray-900 p-6">
              <pre className="text-sm leading-relaxed">
                {`import requests
try:
    response = requests.get(
        "https://dreamcatcher-api.com/members", 
        timeout=10
    )
    response.raise_for_status()
    data = response.json()
    if "members" in data:

        print(data["members"])

        for member in data["members"]:
            print(f"{member['stage_name']}: {member['name']}")
    else:
        print("La clave 'members' no está en la respuesta:", data)

except requests.exceptions.RequestException as e:

    print("Error al hacer la solicitud:", e)`}
              </pre>
            </div>
          )}

          {/* Código de ejemplo - cURL */}
          {activeTab === "curl" && (
            <div className="bg-gray-900 p-6">
              <pre className="text-sm leading-relaxed">
                {`curl -X GET "https://dreamcatcher-api.com/members" \\
     -H "Accept: application/json"
`}
              </pre>
            </div>
          )}
          </div>
        </Card>
      </div>

      <div className="flex justify-between items-center pt-8 border-t border-border/40">
        <p className="text-muted-foreground">Ready to start?</p>
        <Button asChild className="bg-mystery-blue hover:bg-mystery-blue/80">
          <Link to="/docs/getting-started">
            Setup
            <ArrowRight className="ml-2 h-4 w-4" />
          </Link>
        </Button>
      </div>
    </div>
  );
}
