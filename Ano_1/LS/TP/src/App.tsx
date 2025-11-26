import { useEffect, useReducer, useRef, useState } from "react";
import "./App.css";
import Linha from "@/components/Linha";
import {
  MinesweeperContext,
  MinesweeperDispatchContext,
  TempoContext,
} from "./Context";
import {
  AlertDialog,
  AlertDialogContent,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogFooter,
  AlertDialogAction,
} from "@/components/ui/alert-dialog";
import { celulaMode, Jogador } from "./lib/utils";
import Header from "./components/Header";
import Leaderboard from "./components/Leaderboard";

export interface GameState {
  tamTabuleiro: { linhas: number; colunas: number };
  minas: number;
  tabuleiro: number[][];
  selecionados: boolean[][];
  gameOver: boolean;
  reset: boolean;
  celulasMode: celulaMode[][];
  minasRestantes: number;
  playerWon: boolean;
  primeiraJogada: boolean;
  Top9x9: Jogador[];
  Top16x16: Jogador[];
  Top16x30: Jogador[];
}

const initialState: GameState = {
  tamTabuleiro: { linhas: 9, colunas: 9 },
  minas: 10,
  tabuleiro: [[]],
  selecionados: [[]],
  gameOver: false,
  reset: false,
  celulasMode: [[]],
  minasRestantes: 10,
  playerWon: false,
  primeiraJogada: true,
  Top9x9: [],
  Top16x16: [],
  Top16x30: [],
};

function reducer(state: GameState, action: { type: string; payload: any }) {
  switch (action.type) {
    case "SET_TAM_TABULEIRO":
      return { ...state, tamTabuleiro: action.payload };
    case "SET_MINAS":
      return { ...state, minas: action.payload };
    case "SET_TABULEIRO":
      return { ...state, tabuleiro: action.payload };
    case "SET_SELECIONADOS":
      return { ...state, selecionados: action.payload };
    case "SET_GAME_OVER":
      return { ...state, gameOver: action.payload };
    case "SET_RESET":
      return { ...state, reset: action.payload };
    case "SET_CELULAS_MODE":
      return { ...state, celulasMode: action.payload };
    case "SET_MINAS_RESTANTES":
      return { ...state, minasRestantes: action.payload };
    case "SET_PLAYER_WON":
      return { ...state, playerWon: action.payload };
    case "SET_PRIMEIRA_JOGADA":
      return { ...state, primeiraJogada: action.payload };
    case "SET_TOP_9x9":
      return { ...state, Top9x9: action.payload };
    case "SET_TOP_16x16":
      return { ...state, Top16x16: action.payload };
    case "SET_TOP_16x30":
      return { ...state, Top16x30: action.payload };
    default:
      throw new Error();
  }
}

function App() {
  const [tempo, setTempo] = useState(0);
  const [openDialog, setOpenDialog] = useState(false);
  const [state, dispatch] = useReducer(reducer, initialState);
  const [temporizadorComeca, setTemporizadorComeca] = useState(false);
  const usernameSpan = useRef<HTMLSpanElement>(null);
  const [username, setUsername] = useState("");

  function adicionaTop(): void {
    const novoObjeto: Jogador = { username, tempo };

    if (state.tamTabuleiro.linhas === 9 && state.tamTabuleiro.colunas === 9) {
      dispatch({
        type: "SET_TOP_9x9",
        payload: [...state.Top9x9, novoObjeto].sort(
          (a, b) => a.tempo - b.tempo
        ),
      });
      localStorage.setItem(
        "Top9x9",
        JSON.stringify([...state.Top9x9, novoObjeto])
      );
    } else if (
      state.tamTabuleiro.linhas === 16 &&
      state.tamTabuleiro.colunas === 16
    ) {
      dispatch({
        type: "SET_TOP_16x16",
        payload: [...state.Top16x16, novoObjeto].sort(
          (a, b) => a.tempo - b.tempo
        ),
      });
      localStorage.setItem("Top16x16", JSON.stringify(state.Top16x16));
    } else if (
      state.tamTabuleiro.linhas === 16 &&
      state.tamTabuleiro.colunas === 30
    ) {
      dispatch({
        type: "SET_TOP_16x30",
        payload: [...state.Top16x30, novoObjeto].sort(
          (a, b) => a.tempo - b.tempo
        ),
      });
      localStorage.setItem("Top16x30", JSON.stringify(state.Top16x30));
    }
  }

  const gerarMinas = (tab: number[][]) => {
    for (let i = 0; i < state.minas; i++) {
      const linha = Math.floor(Math.random() * state.tamTabuleiro.linhas);
      const coluna = Math.floor(Math.random() * state.tamTabuleiro.colunas);

      if (tab[linha][coluna] === 0) {
        tab[linha][coluna] = -999;
      } else {
        i--;
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
            const newI = i + dx;
            const newJ = j + dy;
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

  const iniciarJogo = () => {
    let newTab: number[][] = [...Array(state.tamTabuleiro.linhas)].map(() =>
      Array(state.tamTabuleiro.colunas).fill(0)
    );

    newTab = gerarMinas(newTab);

    newTab = gerarNumeros(newTab);

    dispatch({ type: "SET_TABULEIRO", payload: newTab });

    dispatch({
      type: "SET_SELECIONADOS",
      payload: [...Array(state.tamTabuleiro.linhas)].map(() =>
        Array(state.tamTabuleiro.colunas).fill(false)
      ),
    });

    dispatch({
      type: "SET_CELULAS_MODE",
      payload: [...Array(state.tamTabuleiro.linhas)].map(() =>
        Array(state.tamTabuleiro.colunas).fill(celulaMode.NORMAL)
      ),
    });

    dispatch({ type: "SET_MINAS_RESTANTES", payload: state.minas });

    setTempo(0);
    dispatch({ type: "SET_GAME_OVER", payload: false });

    dispatch({ type: "SET_PLAYER_WON", payload: false });
    dispatch({ type: "SET_PRIMEIRA_JOGADA", payload: true });
    setTemporizadorComeca(false);
  };

  useEffect(() => {
    iniciarJogo();
  }, [state.tamTabuleiro]);

  useEffect(() => {
    if (!state.gameOver && temporizadorComeca) {
      const interval = setInterval(() => {
        setTempo((tempo) => tempo + 1);
      }, 1000);

      return () => clearInterval(interval);
    }
  }, [state.gameOver, temporizadorComeca]);

  useEffect(() => {
    if (state.reset) {
      iniciarJogo();
    }

    return () => dispatch({ type: "SET_RESET", payload: false });
  }, [state.reset]);

  // contar celulas já selecionadas que não são minas
  useEffect(() => {
    const celulasSelecionadas = state.selecionados
      .flat()
      .filter((celula: boolean) => celula);
    const celulasMinadas = state.tabuleiro
      .flat()
      .filter((celula: number) => celula === -999);

    if (
      celulasSelecionadas.length ===
      state.tamTabuleiro.linhas * state.tamTabuleiro.colunas -
        celulasMinadas.length
    ) {
      dispatch({ type: "SET_GAME_OVER", payload: true });
      dispatch({ type: "SET_PLAYER_WON", payload: true });
      setOpenDialog(true);
    }
  }, [state.selecionados]);

  useEffect(() => {
    return () => {
      setUsername("");
    };
  }, [openDialog]);

  // buscar top a local storage
  useEffect(() => {
    if (localStorage.getItem("Top9x9")) {
      dispatch({
        type: "SET_TOP_9x9",
        payload: JSON.parse(localStorage.getItem("Top9x9")!),
      });
    }
    if (localStorage.getItem("Top16x16")) {
      dispatch({
        type: "SET_TOP_16x16",
        payload: JSON.parse(localStorage.getItem("Top16x16")!),
      });
    }
    if (localStorage.getItem("Top16x30")) {
      dispatch({
        type: "SET_TOP_16x30",
        payload: JSON.parse(localStorage.getItem("Top16x30")!),
      });
    }
  }, []);

  return (
    <MinesweeperContext.Provider value={state}>
      <MinesweeperDispatchContext.Provider value={dispatch}>
        <TempoContext.Provider
          value={{ temporizadorComeca, setTemporizadorComeca }}
        >
          <main className={"flex justify-center items-center flex-col h-full"}>
            <Header tempo={tempo} />

            <table className={`${state.gameOver ? "pointer-events-none" : ""}`}>
              <tbody>
                {state.tabuleiro.map((linha: number[], i: number) => (
                  <Linha
                    key={i}
                    linha={linha}
                    i={i}
                    setOpenDialog={setOpenDialog}
                  />
                ))}
              </tbody>
            </table>

            <Leaderboard />

            <AlertDialog open={openDialog}>
              <AlertDialogContent>
                <AlertDialogHeader>
                  {!state.playerWon ? (
                    <AlertDialogTitle className={"text-center"}>
                      Perdeste
                    </AlertDialogTitle>
                  ) : (
                    <AlertDialogTitle className={"text-center"}>
                      Ganhaste
                    </AlertDialogTitle>
                  )}
                </AlertDialogHeader>
                {state.playerWon && (
                  <div className="flex flex-col gap-4 items-center">
                    <div className="flex gap-2">
                      <input
                        type="text"
                        placeholder="Digite seu nome"
                        className="border border-gray-300 px-2 py-1 rounded"
                        onChange={(e) => setUsername(e.target.value)}
                        required
                      />
                      <span
                        id="aviso"
                        ref={usernameSpan}
                        className="text-3xl font-black text-[#a14242] hidden"
                      >
                        ?
                      </span>
                    </div>
                    <div className="flex gap-2">
                      <p>Tempo:</p>
                      <p>{tempo}s</p>
                    </div>
                    <p>
                      Dificuldade: {state.tamTabuleiro.linhas}x
                      {state.tamTabuleiro.colunas}
                    </p>
                  </div>
                )}
                <AlertDialogFooter className="!justify-center mt-4">
                  <AlertDialogAction
                    className={"font-bold"}
                    onClick={() => {
                      if (state.playerWon) {
                        if (username !== "") {
                          usernameSpan.current!.style.display = "none";
                          adicionaTop();
                          setOpenDialog(false);
                        } else {
                          usernameSpan.current!.style.display = "block";
                        }
                      } else {
                        setOpenDialog(false);
                      }
                    }}
                  >
                    OK
                  </AlertDialogAction>
                  {state.playerWon && (
                    <AlertDialogAction
                      onClick={() => {
                        setOpenDialog(false);
                      }}
                      className="text-red-400 font-bold"
                    >
                      Cancelar
                    </AlertDialogAction>
                  )}
                </AlertDialogFooter>
              </AlertDialogContent>
            </AlertDialog>
          </main>
        </TempoContext.Provider>
      </MinesweeperDispatchContext.Provider>
    </MinesweeperContext.Provider>
  );
}
export default App;
