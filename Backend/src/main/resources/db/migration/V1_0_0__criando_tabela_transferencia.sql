create table transferencia (
    id uuid default random_uuid() primary key,
    contaOringem text,
    contaDestinho text,
    valor numeric,
    taxa numeric,
    dataTransferencia date,
    dataAgendamento date
);