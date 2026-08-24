#language:ru
@helpdesk @api
Функционал: Helpdesk API - Смена статуса тикета
  Сценарий: Негативная проверка перевода статуса тикета из "Закрыт" в "Открыт"

    # Шаг 1. Безопасно подтягиваем credentials из configuration.properties
    * подготовить учетные данные для авторизации

    # Шаг 2. Авторизация и получение токена
    * создать запрос
      | method | path       | body       |
      | POST   | /api/login | login.json |
    * добавить header
      | Content-Type | application/json |
    * отправить запрос
    * статус код 200
    * извлечь данные
      | auth_token | $.token |

    # Шаг 3. Генерация уникального заголовка тикета
    * сгенерировать переменные
      | ticketTitle | Closed Ticket EEEE DDDD |

    # Шаг 4. Создание тикета сразу в статусе CLOSED (status = 4)
    * создать запрос
      | method | path         | body                    |
      | POST   | /api/tickets | createClosedTicket.json |
    * добавить header
      | Authorization | token ${auth_token} |
      | Content-Type  | application/json    |
    * отправить запрос
    * статус код 201
    * извлечь данные
      | ticketId     | $.id     |
      | ticketStatus | $.status |
    * сравнить значения
      | ${ticketStatus} | == | 4 |

    # Шаг 5. Попытка изменить статус на OPEN (status = 1) — должна завершиться ошибкой
    * создать запрос
      | method | path                     | body                        |
      | PUT    | /api/tickets/${ticketId} | updateTicketStatusOpen.json |
    * добавить header
      | Authorization | token ${auth_token} |
      | Content-Type  | application/json    |
    * отправить запрос
    * статус код 422

    # Шаг 6. Проверка, что статус тикета НЕ изменился и остался CLOSED (4)
    * создать запрос
      | method | path                     |
      | GET    | /api/tickets/${ticketId} |
    * добавить header
      | Authorization | token ${auth_token} |
    * отправить запрос
    * статус код 200
    * извлечь данные
      | currentStatus | $.status |
    * сравнить значения
      | ${currentStatus} | == | 4 |