export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";

export function dateBr(date: string) {
    return new Date(date).toLocaleDateString("pt-BR");
}

export function valueBr(amount: number) {
    return new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
    }).format(amount);
}