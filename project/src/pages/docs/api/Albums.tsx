import { Card } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"

export default function Albums() {
  return (
    <div className="space-y-8">
      <div className="space-y-4">
        <h1 className="text-4xl font-bold font-dm-serif text-foreground">
          Get albums
        </h1>
        <p className="text-xl text-muted-foreground leading-relaxed">
          Gets the complete discography of Dreamcatcher including albums, singles and EPs.
        </p>
      </div>

      <Card className="p-6 bg-card/50 border-mystery-accent/20">
        <div className="space-y-4">
          <div className="flex items-center space-x-4">
            <Badge className="bg-green-600 hover:bg-green-700">GET</Badge>
            <code className="text-lg text-mystery-blue font-mono">/albums</code>
          </div>
          
          <p className="text-muted-foreground">
            Endpoint to get all Dreamcatcher albums with detailed information.
          </p>
        </div>
      </Card>

      <div className="space-y-6">
        <h2 className="text-2xl font-semibold font-dm-serif">Response Example</h2>
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="bg-mystery-darker p-6 rounded-lg overflow-x-auto">
            <pre className="text-mystery-glow text-sm">
{`{
  "albums": [
    {
    "id": 1,
    "title": "Why Did You Come To My Home?",
    "tracks": 2,
    "releaseDate": "September 22, 2014"
    },
    {
    "id": 2,
    "title": "Love Shake",
    "tracks": 6,
    "releaseDate": "September 22, 2014"
    },
    {
    "id": 3,
    "title": "Nightmare",
    "tracks": 4,
    "releaseDate": "January 13, 2017"
    },
    {
    "id": 4,
    "title": "Fall asleep in the mirror",
    "tracks": 4,
    "releaseDate": "April 5, 2017"
    },
    {
    "id": 5,
    "title": "Prequel",
    "tracks": 6,
    "releaseDate": "July 27, 2017"
    }
  ]
}`}
            </pre>
          </div>
        </Card>
      </div>
    </div>
  )
}