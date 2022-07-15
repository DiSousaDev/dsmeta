export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";

export function getBrDate(date: string) {
    return new Date(date).toLocaleDateString("pt-BR");
}

export function getInputDate(date: Date) {
    return date.toISOString().slice(0,10);
}

export function getBrValue(amount: number) {
    return new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
    }).format(amount);
}