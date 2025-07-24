import { Link, useLocation } from "react-router-dom";
import { cn } from "@/lib/utils";
import {Book, Settings, Users, Search, Disc3, Music, Info, ChevronRight, } from "lucide-react";
import { LucideIcon } from "lucide-react";
import { useState, useEffect } from "react";

// Define types for our navigation items
type NavItemWithHref = {
  title: string;
  href: string;
  icon: LucideIcon;
  items?: never;
};

type NavItemWithSubItems = {
  title: string;
  icon: LucideIcon;
  items: (NavItemWithHref | NavItemWithSubItems)[];
  href?: never;
};

type NavItem = NavItemWithHref | NavItemWithSubItems;

const navigation: NavItem[] = [
  {
    title: "Introduction",
    href: "/docs/intro",
    icon: Book,
  },
  {
    title: "Before starting",
    href: "/docs/getting-started",
    icon: Settings,
  },
  {
    title: "API",
    icon: ChevronRight,
    items: [
      {
        title: "Members",
        icon: Users,
        items: [
          {
            title: "Get all members",
            href: "/docs/api/members",
            icon: Users,
          },
          {
            title: "Search member by stage name",
            href: "/docs/api/search-member",
            icon: Search,
          },
        ],
      },
      {
        title: "Groups",
        icon: Users,
        items: [
          {
            title: "Get groups",
            href: "/docs/api/groups",
            icon: Users,
          },
          {
            title: "Detailed info about Dreamcatcher",
            href: "/docs/api/dreamcatcher",
            icon: Info,
          },
          {
            title: "Detailed info about Minx",
            href: "/docs/api/minx",
            icon: Info,
          },
        ],
      },
      {
        title: "Albums",
        icon: Music,
        items: [
          {
            title: "Get albums",
            href: "/docs/api/albums",
            icon: Disc3,
          },
          {
            title: "Get songs by album",
            href: "/docs/api/songs",
            icon: Music,
          },
        ],
      },
    ],
  },
];

export function DocsSidebar() {
  const location = useLocation();
  const [openItems, setOpenItems] = useState<Record<string, boolean>>({});

  // Check if the current path matches any item to auto-expand relevant sections
  const initializeOpenItems = () => {
    const currentPath = location.pathname;
    const newOpenItems: Record<string, boolean> = {};

    // Auto-expand API section if we're on an API page
    if (currentPath.includes("/docs/api")) {
      newOpenItems["API"] = true;

      // Auto-expand the specific subsection
      if (
        currentPath.includes("/members") ||
        currentPath.includes("/search-member")
      ) {
        newOpenItems["Members"] = true;
      } else if (
        currentPath.includes("/groups") ||
        currentPath.includes("/dreamcatcher") ||
        currentPath.includes("/minx")
      ) {
        newOpenItems["Groups"] = true;
      } else if (
        currentPath.includes("/albums") ||
        currentPath.includes("/songs")
      ) {
        newOpenItems["Music"] = true;
      }
    }

    return newOpenItems;
  };

  // Initialize open items based on current path
  useEffect(() => {
    const initialOpenItems = initializeOpenItems();
    setOpenItems(initialOpenItems);
  }, [location.pathname]);

  const toggleItem = (title: string) => {
    setOpenItems((prev) => ({
      ...prev,
      [title]: !prev[title],
    }));
  };

  return (
    <div className="w-64 border-r border-border/40 bg-card/30 backdrop-blur-sm">
      <div className="sticky top-16 h-[calc(100vh-4rem)] overflow-y-auto p-6">
        <nav className="space-y-2">
          {navigation.map((item) => {
            if (item.items) {
              const isItemOpen = openItems[item.title] || false;
              return (
                <div key={item.title} className="space-y-2">
                  <button
                    onClick={() => toggleItem(item.title)}
                    className="flex items-center justify-between w-full px-3 py-2 text-sm font-medium text-white/90 hover:bg-accent/30 rounded-md"
                  >
                    <div className="flex items-center space-x-2 ">
                      <item.icon className="h-4 w-4 " />
                      <span>{item.title}</span>
                    </div>
                    <ChevronRight
                      className={cn(
                        "h-4 w-4 transition-transform",
                        isItemOpen ? "rotate-90" : ""
                      )}
                    />
                  </button>
                  {isItemOpen && (
                    <div className="space-y-1 pl-6">
                      {item.items.map((subItem) => {
                        if (subItem.items) {
                          const isSubItemOpen =
                            openItems[subItem.title] || false;
                          return (
                            <div key={subItem.title} className="space-y-2">
                              <button
                                onClick={() => toggleItem(subItem.title)}
                                className="flex items-center justify-between w-full px-3 py-2 text-sm font-medium text-white/90 hover:bg-accent/30 rounded-md"
                              >
                                <div className="flex items-center space-x-2">
                                  <subItem.icon className="h-4 w-4" />
                                  <span>{subItem.title}</span>
                                </div>
                                <ChevronRight
                                  className={cn(
                                    "h-4 w-4 transition-transform",
                                    isSubItemOpen ? "rotate-90" : ""
                                  )}
                                />
                              </button>
                              {isSubItemOpen && (
                                <div className="space-y-1 pl-6">
                                  {subItem.items.map((nestedItem) => {
                                    // This is a NavItemWithHref
                                    const navNestedItem =
                                      nestedItem as NavItemWithHref;
                                    const isActive =
                                      location.pathname === navNestedItem.href;
                                    return (
                                      <Link
                                        key={navNestedItem.href}
                                        to={navNestedItem.href}
                                        className={cn(
                                          "flex items-center space-x-2 px-3 py-2 text-sm rounded-md transition-colors",
                                          isActive
                                            ? "bg-mystery-blue/10 text-mystery-blue font-medium"
                                            : "text-white/90 hover:text-foreground hover:bg-accent/50"
                                        )}
                                      >
                                        <navNestedItem.icon className="h-4 w-4" />
                                        <span className="truncate">
                                          {navNestedItem.title}
                                        </span>
                                      </Link>
                                    );
                                  })}
                                </div>
                              )}
                            </div>
                          );
                        }

                        // This is a NavItemWithHref
                        const navSubItem = subItem as NavItemWithHref;
                        const isActive = location.pathname === navSubItem.href;
                        return (
                          <Link
                            key={navSubItem.href}
                            to={navSubItem.href}
                            className={cn(
                              "flex items-center space-x-2 px-3 py-2 text-sm rounded-md transition-colors",
                              isActive
                                ? "bg-mystery-blue/10 text-mystery-blue font-medium"
                                : "text-white/90 hover:text-foreground hover:bg-accent/50"
                            )}
                          >
                            <navSubItem.icon className="h-4 w-4" />
                            <span className="truncate">{navSubItem.title}</span>
                          </Link>
                        );
                      })}
                    </div>
                  )}
                </div>
              );
            }

            // This is a NavItemWithHref
            const navItem = item as NavItemWithHref;
            const isActive = location.pathname === navItem.href;

            // Apply specific styling for "Before starting"
            const itemSpecificClass =
              navItem.title === "Before starting" ? "text-white/90" : "";

            return (
              <Link
                key={navItem.href}
                to={navItem.href}
                className={cn(
                  "flex items-center space-x-2 px-3 py-2 text-sm rounded-md transition-colors",
                  isActive
                    ? "bg-mystery-blue/10 text-mystery-blue font-medium"
                    : `${itemSpecificClass} hover:text-foreground hover:bg-accent/50`
                )}
              >
                <navItem.icon className="h-4 w-4" />
                <span>{navItem.title}</span>
              </Link>
            );
          })}
        </nav>
      </div>
    </div>
  );
}
