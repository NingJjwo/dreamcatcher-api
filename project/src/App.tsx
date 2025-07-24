import { Toaster } from "@/components/ui/toaster";
import { Toaster as Sonner } from "@/components/ui/sonner";
import { TooltipProvider } from "@/components/ui/tooltip";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { ThemeProvider } from "@/components/ThemeProvider";
import { Navigation } from "@/components/Navigation";
import { DocsLayout } from "@/components/DocsLayout";
import Landing from "./pages/Landing";
import Intro from "./pages/docs/Intro";
import GettingStarted from "./pages/docs/GettingStarted";
import Members from "./pages/docs/api/Members";
import SearchMember from "./pages/docs/api/SearchMember";
import Groups from "./pages/docs/api/Groups";
import Albums from "./pages/docs/api/Albums";
import Songs from "./pages/docs/api/songs";
import Minx from "./pages/docs/api/Minx"
import Dreamcatcher from "./pages/docs/api/Dreamcatcher";
import NotFound from "./pages/NotFound";

const queryClient = new QueryClient();

const App = () => (
  <QueryClientProvider client={queryClient}>
    <ThemeProvider defaultTheme="dark" storageKey="dreamcatcher-ui-theme">
      <TooltipProvider>
        <Toaster />
        <Sonner />
        <BrowserRouter>
          <Navigation />
          <Routes>
            <Route path="/" element={<Landing />} />
            <Route path="/docs" element={<DocsLayout />}>
              <Route path="intro" element={<Intro />} />
              <Route path="getting-started" element={<GettingStarted />} />
              <Route path="api/members" element={<Members />} />
              <Route path="api/search-member" element={<SearchMember />} />
              <Route path="api/groups" element={<Groups />} />
              <Route path="api/albums" element={<Albums />} />
              <Route path="api/dreamcatcher" element={<Dreamcatcher />} />
              <Route path="api/minx" element={<Minx />} />
              <Route path="api/songs" element={<Songs />} />
            </Route>
            {/* ADD ALL CUSTOM ROUTES ABOVE THE CATCH-ALL "*" ROUTE */}
            <Route path="*" element={<NotFound />} />
          </Routes>
        </BrowserRouter>
      </TooltipProvider>
    </ThemeProvider>
  </QueryClientProvider>
);

export default App;
