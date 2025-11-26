import { createContext } from "react";
import { Jogador } from "./lib/utils";

export const MinesweeperContext = createContext<{
  tamTabuleiro: { linhas: number; colunas: number };
  minas: number;
  tabuleiro: number[][];
  selecionados: boolean[][];
  gameOver: boolean;
  reset: boolean;
  celulasMode: number[][];
  minasRestantes: number;
  playerWon: boolean;
  primeiraJogada: boolean;
  Top9x9: Jogador[];
  Top16x16: Jogador[];
  Top16x30: Jogador[];
} | null>(null);
export const MinesweeperDispatchContext = createContext<React.Dispatch<{
  type: string;
  payload: any;
}> | null>(null);

export const TempoContext = createContext<{
  temporizadorComeca: boolean;
  setTemporizadorComeca: React.Dispatch<React.SetStateAction<boolean>>;
} | null>(null);
