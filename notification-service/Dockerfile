FROM python:3.12-alpine AS builder

WORKDIR /app

COPY requirements.txt .

RUN pip install \
    --no-cache-dir \
    --prefix=/install \
    -r requirements.txt


FROM python:3.12-alpine

WORKDIR /app

COPY --from=builder /install /usr/local

COPY app.py .

EXPOSE 5000

USER 1001

CMD ["python", "app.py"]
