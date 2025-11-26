import {
  Sheet,
  SheetContent,
  SheetHeader,
  SheetTitle,
  SheetTrigger,
} from "@/components/ui/sheet";

import LeaderboardItem from "@/components/LeaderboardItem";

import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "./ui/select";
import { useContext, useState } from "react";
import { MinesweeperContext } from "@/Context";

export default function Leaderboard() {
  const state = useContext(MinesweeperContext)!;
  const [dificuldade, setDificuldade] = useState(
    state.tamTabuleiro.linhas + "x" + state.tamTabuleiro.colunas
  );
  return (
    <>
      <Sheet>
        <SheetTrigger className="fixed top-1/2 right-0 transform -translate-y-1/2 flex items-center justify-end bg-[#77B0AA] border-4 border-[#508983]">
          <div className="inline-flex items-center justify-center whitespace-nowrap text-sm font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 hover:text-accent-foreground h-36 w-10">
            <span className="text-sm font-bold -rotate-90 origin-center">
              Leader Board
            </span>
          </div>
        </SheetTrigger>
        <SheetContent className="overflow-y-scroll">
          <SheetHeader className="mb-10">
            <SheetTitle className="text-center text-3xl font-bold mb-4">
              Leader Board
            </SheetTitle>
            <div className="flex items-center">
              <span className="mr-4">Dificuldade:</span>
              <Select defaultValue="9x9" onValueChange={setDificuldade}>
                <SelectTrigger className="w-[100px] text-black border-black border-[2px]">
                  <SelectValue />
                </SelectTrigger>
                <SelectContent className="text-black">
                  <SelectItem value="9x9">9x9</SelectItem>
                  <SelectItem value="16x16">16x16</SelectItem>
                  <SelectItem value="16x30">16x30</SelectItem>
                </SelectContent>
              </Select>
            </div>
          </SheetHeader>

          {dificuldade === "9x9" && (
            <>
              {state.Top9x9.map((jogador, index) => (
                <LeaderboardItem
                  jogador={jogador}
                  index={index}
                  key={jogador.username + index}
                />
              ))}
            </>
          )}

          {dificuldade === "16x16" && (
            <>
              {state.Top16x16.map((jogador, index) => (
                <LeaderboardItem
                  jogador={jogador}
                  index={index}
                  key={jogador.username + index}
                />
              ))}
            </>
          )}

          {dificuldade === "16x30" && (
            <>
              {state.Top16x30.map((jogador, index) => (
                <LeaderboardItem
                  jogador={jogador}
                  index={index}
                  key={jogador.username + index}
                />
              ))}
            </>
          )}
        </SheetContent>
      </Sheet>
    </>
  );
}
