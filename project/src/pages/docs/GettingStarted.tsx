import { Card } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Badge } from "@/components/ui/badge"
import { Link } from "react-router-dom"
import { ArrowRight, Download, Terminal, Play, Github, MessageCircle } from "lucide-react"

export default function GettingStarted() {
  return (
    <div className="space-y-8">
      <div className="space-y-4">
        <h1 className="text-4xl font-bold font-dm-serif text-foreground">
          Before you start
        </h1>
        <p className="text-xl text-muted-foreground leading-relaxed">
          This project is a REST API built with Java + Spring Boot, focused on the history and content of the Dreamcatcher group. It allows you to query members, albums, songs, data about their origins as Minx, and more.
        </p>
      </div>

      <Card className="p-6 bg-gradient-mysterious text-white border-mystery-accent/20">
        <div className="flex items-center space-x-2 mb-4">
          <Terminal className="h-6 w-6" />
          <h2 className="text-2xl font-semibold font-dm-serif">Base URL</h2>
        </div>
        <code className="text-2xl font-mono text-mystery-glow block">
        https://dreamcatcherapi.onrender.com
        </code>
        <p className="mt-4 text-white/80">
          All endpoints use this URL as a base.
        </p>
      </Card>

      <div className="space-y-6">
        <h2 className="text-3xl font-semibold font-dm-serif">Local Installation</h2>
        
        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="flex items-center space-x-2 mb-4">
            <Download className="h-5 w-5 text-mystery-blue" />
            <h3 className="text-xl font-semibold">Requirements</h3>
          </div>
          <ul className="space-y-2 text-muted-foreground">
            <li className="flex items-center space-x-2">
              <Badge variant="secondary">Java 17</Badge>
              <span>Minimum required version</span>
            </li>
            <li className="flex items-center space-x-2">
              <Badge variant="secondary">Maven Wrapper</Badge>
              <span>For dependency management</span>
            </li>
          </ul>
        </Card>

        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="flex items-center space-x-2 mb-4">
            <Terminal className="h-5 w-5 text-mystery-blue" />
            <h3 className="text-xl font-semibold">Installation Commands</h3>
          </div>
          <div className="space-y-4">
            <div>
              <p className="text-sm text-muted-foreground mb-2">1. Clone the repository:</p>
              <div className="bg-mystery-darker p-4 rounded-lg">
                <code className="text-mystery-glow text-sm">
                  git clone https://github.com/NingJjwo/dreamcatcher-api
                </code>
              </div>
            </div>
            
            <div>
              <p className="text-sm text-muted-foreground mb-2">2. Navigate to the directory:</p>
              <div className="bg-mystery-darker p-4 rounded-lg">
                <code className="text-mystery-glow text-sm">
                  cd dreamcatcher-api
                </code>
              </div>
            </div>
            
            <div>
              <p className="text-sm text-muted-foreground mb-2">3. Run the application:</p>
              <div className="bg-mystery-darker p-4 rounded-lg">
                <code className="text-mystery-glow text-sm">
                  ./mvnw spring-boot:run
                </code>
              </div>
            </div>
          </div>
        </Card>

        <Card className="p-6 bg-card/50 border-mystery-accent/20">
          <div className="flex items-center space-x-2 mb-4">
            <Play className="h-5 w-5 text-mystery-blue" />
            <h3 className="text-xl font-semibold">Usage</h3>
          </div>
          <p className="text-muted-foreground mb-4">
            Once running, access the API at:
          </p>
          <div className="bg-mystery-darker p-4 rounded-lg">
            <code className="text-mystery-glow text-lg">
              http://localhost:8080
            </code>
          </div>
        </Card>
      </div>

      <div className="space-y-6">
        <h2 className="text-3xl font-semibold font-dm-serif">Support</h2>
        
        <div className="grid md:grid-cols-2 gap-6">
          <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
            <div className="flex items-center space-x-2 mb-4">
              <Github className="h-5 w-5 text-mystery-blue" />
              <h3 className="text-lg font-semibold">GitHub</h3>
            </div>
            <p className="text-muted-foreground mb-4">
              Report bugs or contribute to the project in our repository.
            </p>
            <Button asChild variant="outline" size="sm">
              <a href="https://github.com/NingJjwo/dreamcatcher-api" target="_blank" rel="noopener noreferrer">
                Go to GitHub
              </a>
            </Button>
          </Card>

          <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
            <div className="flex items-center space-x-2 mb-4">
              <MessageCircle className="h-5 w-5 text-mystery-blue" />
              <h3 className="text-lg font-semibold">Discord</h3>
            </div>
            <p className="text-muted-foreground mb-4">
              Join our community to resolve doubts and get help.
            </p>
            <Button asChild variant="outline" size="sm">
              <a href="#" target="_blank" rel="noopener noreferrer">
                Join Discord
              </a>
            </Button>
          </Card>
        </div>
      </div>

      <div className="flex justify-between items-center pt-8 border-t border-border/40">
        <Button asChild variant="outline">
          <Link to="/docs/intro">
            ← Introduction
          </Link>
        </Button>
        <Button asChild className="bg-mystery-blue hover:bg-mystery-blue/80">
          <Link to="/docs/api/members">
            API Endpoints
            <ArrowRight className="ml-2 h-4 w-4" />
          </Link>
        </Button>
      </div>
    </div>
  )
}