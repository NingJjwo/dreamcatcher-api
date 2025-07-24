import { Card } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"

export default function SearchMember() {
  return (
    <div className="space-y-8">
      <div className="space-y-4">
        <h1 className="text-4xl font-bold font-dm-serif text-foreground">
          Search member by stage name
        </h1>
        <p className="text-xl text-muted-foreground leading-relaxed">
          Search for a specific Dreamcatcher member using their stage name.
        </p>
      </div>

      <Card className="p-6 bg-card/50 border-mystery-accent/20">
        <div className="space-y-4">
          <div className="flex items-center space-x-4">
            <Badge className="bg-green-600 hover:bg-green-700">GET</Badge>
            <code className="text-lg text-mystery-blue font-mono">/members/search/:stageName</code>
          </div>
          
          <p className="text-muted-foreground">
            Search for detailed information about a specific member by their stage name.
          </p>
        </div>
      </Card>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">URL Parameters</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="overflow-x-auto">
            <table className="w-full">
              <thead>
                <tr className="border-b border-mystery-accent/20">
                  <th className="text-left py-2 px-4 font-semibold">Parameter</th>
                  <th className="text-left py-2 px-4 font-semibold">Type</th>
                  <th className="text-left py-2 px-4 font-semibold">Description</th>
                </tr>
              </thead>
              <tbody>
                <tr className="border-b border-mystery-accent/10">
                  <td className="py-2 px-4">
                    <code className="text-mystery-blue">stageName</code>
                  </td>
                  <td className="py-2 px-4">
                    <Badge variant="secondary">string</Badge>
                  </td>
                  <td className="py-2 px-4 text-muted-foreground">
                    Stage name of the member (e.g.: JiU, SuA, Siyeon, etc.)
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Response Example</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="bg-mystery-darker p-6 rounded-lg overflow-x-auto">
            <pre className="text-mystery-glow text-sm">
{`{
  "member": {
    "id": 3,
    "name": "이시연",
    "stage_name": "Siyeon",
    "position": ["Main Vocalist"],
    "birth_date": "1995-10-01",
    "nationality": "South Korean",
    "height": "168 cm",
    "blood_type": "B",
    "zodiac_sign": "Libra",
    "chinese_zodiac": "Pig",
    "representative_animal": "Wolf",
    "representative_color": "Blue",
    "emoji": "🐺",
    "instagram": "@cold_eyes_siyeon",
    "debut_date": "2017-01-13",
    "former_group": "MINX",
    "special_notes": "Known for her powerful vocals and rock style",
    "image_url": "https://dreamcatcher-api.com/images/siyeon.jpg",
    "fun_facts": [
      "Has appeared in several rock collaborations",
      "Known as the 'Vocalist of Dreamcatcher'",
      "Has a very distinctive husky voice"
    ]
  },
  "search_query": "Siyeon",
  "found": true,
  "last_updated": "2025-01-22T10:30:00Z"
}`}
            </pre>
          </div>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Valid Stage Names</h2>
        <Card className="p-6 bg-gradient-mysterious text-white border-mystery-accent/20">
          <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
            <div className="space-y-2">
              <code className="block text-mystery-glow">JiU</code>
              <p className="text-sm text-white/80">Leader, Main Vocalist</p>
            </div>
            <div className="space-y-2">
              <code className="block text-mystery-glow">SuA</code>
              <p className="text-sm text-white/80">Main Dancer</p>
            </div>
            <div className="space-y-2">
              <code className="block text-mystery-glow">Siyeon</code>
              <p className="text-sm text-white/80">Main Vocalist</p>
            </div>
            <div className="space-y-2">
              <code className="block text-mystery-glow">Handong</code>
              <p className="text-sm text-white/80">Sub Vocalist</p>
            </div>
            <div className="space-y-2">
              <code className="block text-mystery-glow">Yoohyeon</code>
              <p className="text-sm text-white/80">Lead Vocalist</p>
            </div>
            <div className="space-y-2">
              <code className="block text-mystery-glow">Dami</code>
              <p className="text-sm text-white/80">Main Rapper</p>
            </div>
            <div className="space-y-2">
              <code className="block text-mystery-glow">Gahyeon</code>
              <p className="text-sm text-white/80">Lead Rapper</p>
            </div>
          </div>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Usage Example</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="space-y-4">
            <h3 className="text-lg font-semibold">JavaScript (Fetch)</h3>
            <div className="bg-mystery-darker p-4 rounded-lg">
              <pre className="text-mystery-glow text-sm">
{`const stageName = "Siyeon";
const response = await fetch(\`https://github.com/NingJjwo/dreamcatcher-api/members/search/\${stageName}\`);
const data = await response.json();

if (data.found) {
  console.log(data.member);
} else {
  console.log("Member not found");
}`}
              </pre>
            </div>
          </div>

          <div className="space-y-4 mt-6">
            <h3 className="text-lg font-semibold">TypeScript</h3>
            <div className="bg-mystery-darker p-4 rounded-lg">
              <pre className="text-mystery-glow text-sm">
{`interface Member {
  id: number;
  name: string;
  stage_name: string;
  position: string[];
  // ... other properties
}

const searchMember = async (stageName: string): Promise<Member | null> => {
  const response = await fetch(\`https://github.com/NingJjwo/dreamcatcher-api/members/search/\${stageName}\`);
  const data = await response.json();
  
  return data.found ? data.member : null;
};`}
              </pre>
            </div>
          </div>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Response Codes</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="space-y-4">
            <div className="flex items-center space-x-4">
              <Badge className="bg-green-600">200</Badge>
              <span>OK - Member found successfully</span>
            </div>
            <div className="flex items-center space-x-4">
              <Badge className="bg-yellow-600">404</Badge>
              <span>Not Found - Member not found</span>
            </div>
            <div className="flex items-center space-x-4">
              <Badge className="bg-red-600">400</Badge>
              <span>Bad Request - Invalid stage name</span>
            </div>
          </div>
        </Card>
      </div>
    </div>
  )
}
