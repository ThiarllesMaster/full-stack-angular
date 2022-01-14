import { CampoException } from "./campo.livro.exception";

export interface LivroException {
    status: string
    titulo: string
    campos?: CampoException[]
}