import { Card } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { useState } from "react";

export default function Members() {
  const [activeTab, setActiveTab] = useState("javascript");
  return (
    <div className="space-y-8">
      <div className="space-y-4">
        <h1 className="text-4xl font-bold font-dm-serif text-foreground">
          Get all members
        </h1>
        <p className="text-xl text-muted-foreground leading-relaxed">
          Gets complete information of all current Dreamcatcher members.
        </p>
      </div>

      <Card className="p-6 bg-card/50 border-mystery-accent/20">
        <div className="space-y-4">
          <div className="flex items-center space-x-4">
            <Badge className="bg-green-600 hover:bg-green-700">GET</Badge>
            <Badge className="bg-green-600 hover:bg-green-700">/members</Badge>
          </div>

          <p className="text-muted-foreground">
            Endpoint to get the complete list of Dreamcatcher members with detailed information.
          </p>
        </div>
      </Card>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Parameters</h2>
        <Card className="p-6 bg-muted/30">
          <p className="text-muted-foreground italic">
            This endpoint doesn't require parameters.
          </p>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">
          Response Example
        </h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="bg-mystery-darker p-6 rounded-lg overflow-x-auto">
            <pre className="text-mystery-glow text-sm">
              <code className="text-left">
                <span>{'{'}</span><br />
                <span>&nbsp;&nbsp;</span><span className="text-pink-400">"members"</span><span>: [</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;{'{'}</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"id"</span><span>: </span><span className="text-amber-400">1</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"realName"</span><span>: </span><span className="text-green-400">"Kim Minji"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"stageName"</span><span>: </span><span className="text-green-400">"JiU"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"koreanName"</span><span>: </span><span className="text-green-400">"김민지"</span><span>, </span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"role"</span><span>: </span><span className="text-green-400">"Leader, leadvocalist, leaddancer, visual"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"dateBorn"</span><span>: </span><span className="text-green-400">"1994/05/17"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"nationality"</span><span>: </span><span className="text-green-400">"Korean"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"cityBorn"</span><span>: </span><span className="text-green-400">"Daejeon"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"nightmare"</span><span>: </span><span className="text-green-400">"Fear of Being chased by someone"</span>,<br/>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"image"</span><span>: </span><span className="text-green-400">"https://dreamcatcherapi.onrender.com/images/members/jiu.png"</span>,<span><br/>
                {'}'},</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;{'{'}</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"id"</span><span>: </span><span className="text-amber-400">2</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"realName"</span><span>: </span><span className="text-green-400">"Kim Bora"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"stageName"</span><span>: </span><span className="text-green-400">"SuA"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"koreanName"</span><span>: </span><span className="text-green-400">"김보라"</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"role"</span><span>: </span><span className="text-green-400">"Maindancer, leadrapper, subvocalist"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"dateBorn"</span><span>: </span><span className="text-green-400">"1994/08/10"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"nationality"</span><span>: </span><span className="text-green-400">"Korean"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"cityBorn"</span><span>: </span><span className="text-green-400">"Changwon"</span><span>,</span><br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"nightmare"</span><span>: </span><span className="text-green-400">"Fear of Being restraint / Uneable to move"</span>,<br />
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span className="text-pink-400">"image"</span><span>: </span><span className="text-green-400">"https://dreamcatcherapi.onrender.com/images/members/jiu.png"</span>,<span><br/>                
                {'}'},</span><br />
                <span>&nbsp;&nbsp;]</span><span>,</span><br />
                
                <span>{'}'}</span>
              </code>
            </pre>
          </div>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Usage Example</h2>

        <div className="bg-black rounded-lg overflow-hidden shadow-lg">
          {/* Endpoint URL con método GET */}
          <div className="flex items-center p-4 border-b border-gray-800">
            <div className="flex items-center mr-2">
              <span className="text-green-500 font-semibold mr-1">GET</span>
              <span className="text-green-500">➔</span>
            </div>
            <code className="text-blue-400">
              https://dreamcatcher-api.com/members
            </code>
          </div>

          {/* Tabs para los diferentes lenguajes */}
          <div className="flex border-b border-gray-800">
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
        print("The 'members' key is not in the response:", data)

except requests.exceptions.RequestException as e:

    print("Error making the request:", e)`}
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
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">
          Response Codes
        </h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="space-y-4">
            <div className="flex items-center space-x-4">
              <Badge className="bg-green-600">200</Badge>
              <span>OK - Members successfully retrieved</span>
            </div>
            <div className="flex items-center space-x-4">
              <Badge className="bg-red-600">500</Badge>
              <span>Internal Server Error - Server internal error</span>
            </div>
          </div>
        </Card>
      </div>
    </div>
  );
}
