import { Link, useLocation, useNavigate } from "react-router-dom";
import { Button } from "@/components/ui/button";
import { ThemeToggle } from "@/components/ThemeToggle";
import { Github, Search } from "lucide-react";
import { useState, useEffect } from "react";
import {
  CommandDialog,
  CommandEmpty,
  CommandGroup,
  CommandInput,
  CommandItem,
  CommandList,
} from "@/components/ui/command";

export function Navigation() {
  const location = useLocation();
  const navigate = useNavigate();
  const [open, setOpen] = useState(false);

  // Lista de páginas de documentación para buscar
  const docPages = [
    { title: "Dreamcatcher", path: "/" },
    { title: "Introducción", path: "/docs/intro" },
    { title: "Primeros pasos", path: "/docs/getting-started" },
    { title: "API - Albums", path: "/docs/api/albums" },
    { title: "API - Groups", path: "/docs/api/groups" },
    { title: "API - Members", path: "/docs/api/members" },
    { title: "API - Búsqueda de miembros", path: "/docs/api/search-member" },
  ];

  // Atajo de teclado para abrir el buscador (Ctrl+K o ⌘+K)
  useEffect(() => {
    const down = (e: KeyboardEvent) => {
      if ((e.key === "k" && (e.metaKey || e.ctrlKey)) || e.key === "/") {
        e.preventDefault();
        setOpen((open) => !open);
      }
    };

    document.addEventListener("keydown", down);
    return () => document.removeEventListener("keydown", down);
  }, []);

  return (
<nav className="fixed top-0 w-full z-50  bg-transparent backdrop-blur-none">
      <div className="container flex h-16 items-center">
        <div className="mr-4 hidden md:flex">
          <Link to="/" className="mr-6 flex items-center space-x-2">
            <span className="hidden font-bold font-dm-serif text-xl text-foreground sm:inline-block">
              Dreamcatcher API
            </span>
          </Link>
          <nav className="flex items-center space-x-6 text-sm font-medium">
            <Link
              to="/docs/Intro"
              className={`transition-colors hover:text-foreground/80 ${
                location.pathname.startsWith("/docs")
                  ? "text-foreground"
                  : "text-foreground/60"
              }`}
            >
              Documentation
            </Link>
          </nav>
        </div>

        <div className="flex flex-1 items-center justify-between space-x-2 md:justify-end">
          <div className="w-full flex-1 md:w-auto md:flex-none flex items-center">
            <Button
              asChild
              variant="ghost"
              size="sm"
              className="hidden md:inline-flex mr-2"
            >
              <a
                href="https://github.com/NingJjwo/dreamcatcher-api"
                target="_blank"
                rel="noopener noreferrer"
              >
                <Github className="h-4 w-4" />
                <span className="ml-2">GitHub</span>
              </a>
            </Button>

            {/* Botón de búsqueda */}
            <Button
              variant="outline"
              size="sm"
              className="hidden h-9 justify-between text-sm text-muted-foreground sm:flex"
              onClick={() => setOpen(true)}
            >
              <div className="flex items-center">
                <Search className="mr-2 h-4 w-4" />
                <span>Buscar</span>
              </div>
              <kbd className="pointer-events-none ml-2 hidden h-5 select-none items-center gap-1 rounded border bg-muted px-1.5 font-mono text-[10px] font-medium opacity-100 sm:flex">
                <span className="text-xs">ctrl</span>- K
              </kbd>
            </Button>
          </div>
          <ThemeToggle />

          {/* Diálogo de búsqueda */}
          <CommandDialog open={open} onOpenChange={setOpen}>
            <CommandInput placeholder="Buscar en la documentación..." />
            <CommandList>
              <CommandEmpty>No se encontraron resultados.</CommandEmpty>
              <CommandGroup heading="Documentación">
                {docPages.map((page) => (
                  <CommandItem
                    key={page.path}
                    onSelect={() => {
                      navigate(page.path);
                      setOpen(false);
                    }}
                  >
                    <Search className="mr-2 h-4 w-4" />
                    {page.title}
                  </CommandItem>
                ))}
              </CommandGroup>
            </CommandList>
          </CommandDialog>
        </div>
      </div>
    </nav>
  );
}
