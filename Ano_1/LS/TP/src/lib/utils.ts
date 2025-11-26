import { type ClassValue, clsx } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export enum celulaMode {
  NORMAL = 0,
  FLAG = 1,
  UNCERTAIN = 2,
}

export interface Jogador{
  username: string;
  tempo: number; 
}
