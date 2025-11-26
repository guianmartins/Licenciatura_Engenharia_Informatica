import { useCallback, useContext } from "react";
import {
  MinesweeperContext,
  MinesweeperDispatchContext,
  TempoContext,
} from "../Context";
import { celulaMode } from "@/lib/utils";

interface CelulaProps {
  celula: number;
  i: number;
  j: number;
  setOpenDialog: (open: boolean) => void;
}

export default function Celula({ celula, i, j, setOpenDialog }: CelulaProps) {
  const state = useContext(MinesweeperContext)!;
  const dispatch = useContext(MinesweeperDispatchContext)!;
  const { setTemporizadorComeca } = useContext(TempoContext)!;

  /**
   * Encontra todas as celulas vazias adjacentes a uma celula clicada utilizando o algoritmo Breadth First Search
   */
  const bfs = (
    tab: number[][],
    selecionados: boolean[][],
    i: number,
    j: number
  ) => {
    const dirs = [
      [-1, -1],
      [-1, 0],
      [-1, 1],
      [0, -1],
      [0, 1],
      [1, -1],
      [1, 0],
      [1, 1],
    ];

    const espera = [[i, j]];
    while (espera.length > 0) {
      const [x, y] = espera.shift()!;
      if (
        x >= 0 &&
        x < state.tamTabuleiro.linhas &&
        y >= 0 &&
        y < state.tamTabuleiro.colunas &&
        !selecionados[x][y]
      ) {
        selecionados[x][y] = true;
        if (tab[x][y] === 0) {
          for (const [dx, dy] of dirs) {
            espera.push([x + dx, y + dy]);
          }
        }
      }
    }
  };

  const resetarNumeros = (tab: number[][]) => {
    for (let i = 0; i < state.tamTabuleiro.linhas; i++) {
      for (let j = 0; j < state.tamTabuleiro.colunas; j++) {
        if (tab[i][j] !== -999) {
          tab[i][j] = 0;
        }
      }
    }
    return tab;
  };

  const gerarNumeros = (tab: number[][]) => {
    const dirs = [
      [-1, -1],
      [-1, 0],
      [-1, 1],
      [0, -1],
      [0, 1],
      [1, -1],
      [1, 0],
      [1, 1],
    ];

    for (let i = 0; i < state.tamTabuleiro.linhas; i++) {
      for (let j = 0; j < state.tamTabuleiro.colunas; j++) {
        if (tab[i][j] === -999) {
          dirs.forEach(([dx, dy]) => {
            const newI = i + dx,
              newJ = j + dy;
            if (
              newI >= 0 &&
              newI < state.tamTabuleiro.linhas &&
              newJ >= 0 &&
              newJ < state.tamTabuleiro.colunas &&
              tab[newI][newJ] !== -999
            ) {
              tab[newI][newJ]++;
            }
          });
        }
      }
    }

    return tab;
  };

  const celulaClicada = (i: number, j: number) => {
    if (state.celulasMode[i][j] === celulaMode.FLAG) return;

    let tabuleiro = [...state.tabuleiro];

    if (state.primeiraJogada) {
      setTemporizadorComeca(true);
    }

    if (state.primeiraJogada && tabuleiro[i][j] === -999) {
      tabuleiro[i][j] = 0;
      do {
        const linha = Math.floor(Math.random() * state.tamTabuleiro.linhas);
        const coluna = Math.floor(Math.random() * state.tamTabuleiro.colunas);
        if (tabuleiro[linha][coluna] !== -999) {
          tabuleiro[linha][coluna] = -999;
          break;
        }
      } while (true);
      tabuleiro = resetarNumeros(tabuleiro);
      tabuleiro = gerarNumeros(tabuleiro);
      dispatch({ type: "SET_TABULEIRO", payload: tabuleiro });
      dispatch({ type: "SET_PRIMEIRA_JOGADA", payload: false });
    }

    const newSelecionados = [...state.selecionados];
    if (tabuleiro[i][j] === 0) {
      bfs(tabuleiro, newSelecionados, i, j);
    } else if (tabuleiro[i][j] === -999) {
      for (let i = 0; i < state.tamTabuleiro.linhas; i++) {
        for (let j = 0; j < state.tamTabuleiro.colunas; j++) {
          newSelecionados[i][j] = true;
        }
      }
      dispatch({ type: "SET_GAME_OVER", payload: true });
      setOpenDialog(true);
    } else {
      newSelecionados[i][j] = true;
    }
    dispatch({ type: "SET_SELECIONADOS", payload: newSelecionados });
    dispatch({ type: "SET_PRIMEIRA_JOGADA", payload: false });
  };

  const handleRightClick = useCallback(
    (e: React.MouseEvent, i: number, j: number) => {
      e.preventDefault();
      if (state.selecionados[i][j]) return;
      const newCelulasMode = [...state.celulasMode];
      if (newCelulasMode[i][j] === celulaMode.NORMAL) {
        if (state.minasRestantes === 0) return;

        newCelulasMode[i][j] = celulaMode.FLAG;
        dispatch({
          type: "SET_MINAS_RESTANTES",
          payload: state.minasRestantes - 1,
        });
      } else if (newCelulasMode[i][j] === celulaMode.FLAG) {
        newCelulasMode[i][j] = celulaMode.UNCERTAIN;
        dispatch({
          type: "SET_MINAS_RESTANTES",
          payload: state.minasRestantes + 1,
        });
      } else {
        newCelulasMode[i][j] = celulaMode.NORMAL;
      }
      dispatch({ type: "SET_CELULAS_MODE", payload: newCelulasMode });
    },
    [state.selecionados, state.celulasMode, dispatch]
  );

  const topBorder =
    state.selecionados[i][j] && i > 0 && !state.selecionados[i - 1][j]
      ? "border-t-2 border-[#135D66]"
      : "";
  const bottomBorder =
    state.selecionados[i][j] &&
    i < state.selecionados.length - 1 &&
    !state.selecionados[i + 1][j]
      ? "border-b-2 border-[#135D66]"
      : "";
  const leftBorder =
    state.selecionados[i][j] && j > 0 && !state.selecionados[i][j - 1]
      ? "border-l-2 border-[#135D66]"
      : "";
  const rightBorder =
    state.selecionados[i][j] &&
    j < state.selecionados[i].length - 1 &&
    !state.selecionados[i][j + 1]
      ? "border-r-2 border-[#135D66]"
      : "";

  return (
    <td
      className={`text-center w-10 h-10 text-gray-800 font-bold
        ${(i + j) % 2 === 0 ? "bg-[#77B0AA]" : "bg-[#508983]"} 
        ${!state.selecionados[i][j] ? "cursor-pointer" : "cursor-default"}
        ${
          state.selecionados[i][j]
            ? (i + j) % 2 === 0
              ? "bg-[#77B0AA]"
              : "bg-[#9dc6c1]"
            : ""
        }
        ${topBorder} ${bottomBorder} ${leftBorder} ${rightBorder}
        `}
      onClick={() => celulaClicada(i, j)}
      onContextMenu={(e) => handleRightClick(e, i, j)}
    >
      {state.selecionados[i][j] ? (
        celula === -999 ? (
          <span role={"img"} aria-label={"bomba"} className={"relative"}>
            <img
              src={"/explosion.gif"}
              className={`${state.gameOver ? "" : "hidden"}
              absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 w-3/4`}
            />
            💣
          </span>
        ) : celula === 0 ? (
          ""
        ) : (
          celula
        )
      ) : state.celulasMode[i][j] === 0 ? (
        ""
      ) : state.celulasMode[i][j] === 1 ? (
        "🚩"
      ) : (
        "❓"
      )}
    </td>
  );
}
