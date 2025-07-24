import { Card } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"

export default function Minx() {
  return (
    <div className="space-y-8">
      <div className="space-y-4">
        <h1 className="text-4xl font-bold font-dm-serif text-foreground">
          Get Minx
        </h1>
        <p className="text-xl text-muted-foreground leading-relaxed">
          Get information about the Minx group.
        </p>
      </div>

      <Card className="p-6 bg-card/50 border-mystery-accent/20">
        <div className="space-y-4">
          <div className="flex items-center space-x-4">
            <Badge className="bg-green-600 hover:bg-green-700">GET</Badge>
            <code className="text-lg text-white/90 font-mono">/groupData/Minx</code>
          </div>
          
          <p className="text-muted-foreground">
            Endpoint to get basic information about Minx.
          </p>
        </div>
      </Card>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Response Example</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="bg-mystery-darker p-6 rounded-lg overflow-x-auto">
            <pre className="text-mystery-glow text-sm">
{`{
  "groups": [
    {
      "id": 1,
      "name": "Minx",
      "formationDate": "2014-09-15",
      "company": "Happy Face Entertainment",
      "description": "The predecessor to Dreamcatcher, originally debuted as a six-member girl group with a more traditional K-pop style before their transformation.",
      "members": [
      "JiU",
      "SuA",
      "Siyeon",
      "Yoohyeon",
      "Dami",
      "Gahyeon"
      ]
      },
      {
      "id": 2,
      "name": "Dreamcatcher",
      "formationDate": "2017-01-13",
      "company": "Happy Face Entertainment",
      "description": "A South Korean girl group known for their unique rock-inspired music and dark, cinematic concepts, consisting of seven members.",
      "members": [
      "JiU",
      "SuA",
      "Siyeon",
      "Handong",
      "Yoohyeon",
      "Dami",
      "Gahyeon"
      ]
      }
  ],
  "total_groups": 2
}`}
            </pre>
          </div>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Usage Example</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="bg-mystery-darker p-4 rounded-lg">
            <pre className="text-mystery-glow text-sm">
{`const response = await fetch("https://dreamcatcherapi.onrender.com/groupData");
const data = await response.json();
console.log(data.groups);`}
            </pre>
          </div>
        </Card>
      </div>
    </div>
  )
}