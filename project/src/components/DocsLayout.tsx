import { Outlet } from "react-router-dom"
import { DocsSidebar } from "@/components/DocsSidebar"

export function DocsLayout() {
  return (
    <div className="flex min-h-screen pt-16">
      <DocsSidebar />
      <main className="flex-1 overflow-x-hidden">
        <div className="container max-w-4xl mx-auto py-8 px-6">
          <Outlet />
        </div>
      </main>
    </div>
  )
}