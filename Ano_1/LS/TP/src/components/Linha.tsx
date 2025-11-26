import Celula from "./Celula";

interface LinhaProps {
  linha: number[];
  i: number;
  setOpenDialog: (open: boolean) => void;
}

export default function Linha({ linha, i, setOpenDialog }: LinhaProps) {
  return (
    <tr>
      {linha.map((celula, j) => (
        <Celula
          key={j}
          celula={celula}
          i={i}
          j={j}
          setOpenDialog={setOpenDialog}
        />
      ))}
    </tr>
  );
}
