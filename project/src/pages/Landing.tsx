import { Link } from "react-router-dom";
import { useRef, useEffect } from "react";
import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import { Github, BookOpen, ArrowRight } from "lucide-react";
import heroVideo from "@/assets/fondo1.mp4";

export default function Landing() {
  const videoRef = useRef<HTMLVideoElement>(null);

  useEffect(() => {
    if (videoRef.current) {
      videoRef.current
        .play()
        .then(() => {
          // Una vez que el video está reproduciéndose, podemos ajustar el volumen
          videoRef.current!.volume = 0.1;
        })
        .catch((error) => {
          console.error("Error al reproducir el video:", error);
          // Si falla la reproducción automática, podemos intentar silenciar primero
          if (videoRef.current) {
            videoRef.current.muted = true;
            videoRef.current
              .play()
              .catch((e) =>
                console.error(
                  "No se pudo reproducir el video incluso silenciado:",
                  e
                )
              );
          }
        });
    }
  }, []);

  return (
    <div className="min-h-screen bg-gradient-subtle">
      {/* Hero Section */}
      <section className="relative overflow-hidden">
        <video
          ref={videoRef}
          className="absolute inset-0 w-full h-full object-cover opacity-100 dark:opacity-100"
          autoPlay

          loop
          playsInline
        >
          <source src={heroVideo} type="video/mp4" />
        </video>
        <div className="absolute inset-0 bg-gradient-to-b from-background/50 via-background/70 to-background" />

        <div className="relative container mx-auto px-4 pt-32 pb-20">
          <div className="max-w-4xl mx-auto text-center">
            <h1 className="text-5xl md:text-7xl font-bold font-dm-serif mb-6 text-foreground leading-tight">
              Dreamcatcher
              <span className="block text-mystery-accent">API</span>
            </h1>

            <p className="text-xl md:text-1xl text-muted-foreground mb-8 max-w-2xl mx-auto leading-relaxed font-inter text-balance">
              Dreamcatcher API is an open source platform that provides access
              to detailed information about the South Korean band Dreamcatcher,
              including their members, albums, songs, evolution since Minx and
              conceptual elements such as their nightmares, all through
              structured and easy-to-use endpoints.
            </p>

            <div className="flex flex-col sm:flex-row gap-4 justify-center mb-16">
              <Button
                asChild
                size="lg"
                className="bg-mystery-blue hover:bg-mystery-blue/80 text-white shadow-mysterious"
              >
                <Link to="/docs/intro">
                  <BookOpen className="mr-2 h-5 w-5" />
                  Get Started
                  <ArrowRight className="ml-2 h-5 w-5" />
                </Link>
              </Button>

              <Button
                asChild
                variant="outline"
                size="lg"
                className="border-mystery-accent/20 hover:bg-mystery-accent/10"
              >
                <a
                  href="https://github.com/NingJjwo/dreamcatcher-api"
                  target="_blank"
                  rel="noopener noreferrer"
                >
                  <Github className="mr-2 h-5 w-5" />
                  View on GitHub
                </a>
              </Button>
            </div>
          </div>
        </div>
      </section>

      {/* Features Section */}
      <section className="py-20 px-4">
        <div className="container mx-auto">
          <div className="max-w-6xl mx-auto">
            <h2 className="text-3xl md:text-4xl font-bold text-center mb-12 font-dm-serif">
              API Endpoints
            </h2>

            <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
              <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
                <h3 className="text-xl font-semibold mb-3 text-mystery-blue">
                  Members
                </h3>
                <p className="text-muted-foreground mb-4">
                  Get detailed information about all Dreamcatcher members
                </p>
                <code className="text-sm bg-muted p-2 rounded block text-mystery-accent">
                  GET /members
                </code>
              </Card>

              <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
                <h3 className="text-xl font-semibold mb-3 text-mystery-blue">
                  Albums
                </h3>
                <p className="text-muted-foreground mb-4">
                  Explore the complete discography of the group
                </p>
                <code className="text-sm bg-muted p-2 rounded block text-mystery-accent">
                  GET /albums
                </code>
              </Card>

              <Card className="p-6 bg-card/50 border-mystery-accent/20 hover:shadow-glow transition-all duration-300">
                <h3 className="text-xl font-semibold mb-3 text-mystery-blue">
                  Songs
                </h3>
                <p className="text-muted-foreground mb-4">
                  Access songs organized by album
                </p>
                <code className="text-sm bg-muted p-2 rounded block text-mystery-accent">
                  GET /songs/:album
                </code>
              </Card>
            </div>
          </div>
        </div>
      </section>

      {/* Authors Section */}
      <section className="py-20 px-4 bg-gradient-mysterious text-white">
        <div className="container mx-auto">
          <div className="max-w-4xl mx-auto text-center">
            <h2 className="text-3xl md:text-4xl font-bold mb-8 font-dm-serif">
              Project Authors
            </h2>

            <div className="grid md:grid-cols-2 gap-8">
              <Card className="p-6 bg-white/10 border-white/20 backdrop-blur-sm">
                <h3 className="text-xl font-semibold mb-2">NingJjwo</h3>
                <p className="text-white/80 mb-4">
                  Computer science student & Reverse Engineering
                </p>
                <a
                  href="https://github.com/NingJjwo"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-mystery-glow hover:text-white transition-colors"
                >
                  @NingJjwo
                </a>
              </Card>

              <Card className="p-6 bg-white/10 border-white/20 backdrop-blur-sm">
                <h3 className="text-xl font-semibold mb-2">Julian Rosales</h3>
                <p className="text-white/80 mb-4">Web Developer</p>
                <a
                  href="https://julian-links.vercel.app/"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-mystery-glow hover:text-white transition-colors"
                >
                  @Julian.dev
                </a>
              </Card>
            </div>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="py-8 px-4 border-t border-border/40">
        <div className="container mx-auto text-center">
          <p className="text-muted-foreground text-sm">
            MIT License — 2025 Dreamcatcher API
          </p>
          <p className="text-muted-foreground text-xs mt-2">
            The software is provided "as is", without warranty of any kind.
          </p>
        </div>
      </footer>
    </div>
  );
}
