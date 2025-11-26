import { Jogador } from "@/lib/utils";

interface LeaderboardItemProps {
  jogador: Jogador;
  index: number;
}

export default function LeaderboardItem({
  jogador,
  index,
}: LeaderboardItemProps) {
  return (
    <div
      key={index}
      className="w-full bg-[#77B0AA] h-20 border-4 border-[#508983] rounded-md mb-5 flex justify-around items-center"
    >
      <span className=" text-4xl font-bold">{index + 1}.</span>
      <p className="text-2xl">{jogador.username}</p>
      <p className="text-2xl">{jogador.tempo}s</p>
    </div>
  );
}
