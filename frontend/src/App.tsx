import React from 'react';

const mockCase = {
  caseId: 'CASE123',
  registrationNo: 'REG123',
  clientName: 'Acme Corp',
  country: 'UK',
  sla: '24h',
  assignedTo: 'Alice',
  fastTrackStatus: true,
};

const mockComparison = {
  cdd: {
    fullLegalName: 'Acme Corporation Ltd',
    registeredNumber: '12345678',
    registeredAddress: '1 Acme St, London',
    legalForm: 'Private Limited',
    countryOfEstablishment: 'UK',
    dateOfIncorporation: '2010-01-01',
    tradingName: 'Acme',
  },
  companiesHouse: {
    fullLegalName: 'Acme Corporation Ltd',
    registeredNumber: '12345678',
    registeredAddress: '1 Acme St, London',
    legalForm: 'Private Limited',
    countryOfEstablishment: 'UK',
    dateOfIncorporation: '2010-01-01',
    tradingName: 'Acme',
  },
  customerSystem: {
    fullLegalName: 'Acme Corporation Ltd',
    registeredNumber: '12345678',
    registeredAddress: '2 Acme St, London',
    legalForm: 'Private Limited',
    countryOfEstablishment: 'UK',
    dateOfIncorporation: '2010-01-01',
    tradingName: 'Acme',
  },
};

const mockAI = {
  conflicts: [
    { field: 'registeredAddress', issue: 'Mismatch' },
  ],
  missingFields: ['dateOfIncorporation'],
  recommendation: 'Fast Track',
};

const fields = [
  { label: 'Full legal name', key: 'fullLegalName' },
  { label: 'Registered number', key: 'registeredNumber' },
  { label: 'Registered/business address', key: 'registeredAddress' },
  { label: 'Legal form', key: 'legalForm' },
  { label: 'Country of establishment', key: 'countryOfEstablishment' },
  { label: 'Date of incorporation', key: 'dateOfIncorporation' },
  { label: 'Trading name', key: 'tradingName' },
];

function getStatus(field: string) {
  if (mockAI.conflicts.some((c) => c.field === field)) return 'conflict';
  if (mockAI.missingFields.includes(field)) return 'missing';
  return 'match';
}

const Sidebar = () => (
  <aside className="w-full md:w-72 bg-gray-50 border-l p-4 flex flex-col gap-6">
    <div className="bg-white rounded shadow p-4">
      <h3 className="font-bold mb-2">Agent I – Data Intelligence</h3>
      <div>
        <div className="mb-2 text-sm">Conflicts:</div>
        {mockAI.conflicts.map((c, i) => (
          <div key={i} className="text-conflict text-xs">{c.field}: {c.issue}</div>
        ))}
        <div className="mt-2 text-sm">Missing:</div>
        {mockAI.missingFields.map((f, i) => (
          <div key={i} className="text-missing text-xs">{f}</div>
        ))}
      </div>
    </div>
    <div className="bg-white rounded shadow p-4">
      <h3 className="font-bold mb-2">Assistant P – Policy Guidance</h3>
      <div className="text-sm">Recommendation: <span className="font-semibold text-green-600">{mockAI.recommendation}</span></div>
      <div className="text-xs mt-2 text-gray-500">Standard if mismatch. Fast Track if all matched. EDD if data is risky or incomplete.</div>
    </div>
    <div className="bg-white rounded shadow p-4">
      <h3 className="font-bold mb-2">Assistant J – Journey Optimizer</h3>
      <div className="text-sm">Onboarding Route: <span className="font-semibold">{mockAI.recommendation}</span></div>
    </div>
  </aside>
);

function App() {
  return (
    <div className="min-h-screen bg-gray-100">
      {/* Header */}
      <header className="bg-white shadow p-4 flex flex-wrap gap-4 items-center justify-between">
        <div className="flex flex-wrap gap-4 items-center">
          <span className="font-bold text-lg">Case ID: {mockCase.caseId}</span>
          <span>Registration No: {mockCase.registrationNo}</span>
          <span>Client Name: {mockCase.clientName}</span>
          <span>Country: {mockCase.country}</span>
          <span>SLA: <span className="text-blue-600 font-semibold">{mockCase.sla}</span></span>
          <span>Assigned To: {mockCase.assignedTo}</span>
        </div>
        <div className="flex items-center gap-2">
          <span className={`px-2 py-1 rounded text-xs font-bold ${mockCase.fastTrackStatus ? 'bg-green-100 text-green-700' : 'bg-yellow-100 text-yellow-700'}`}>{mockCase.fastTrackStatus ? 'Fast Track' : 'Standard'}</span>
        </div>
      </header>
      {/* Main Content */}
      <main className="flex flex-col md:flex-row gap-0 md:gap-4 p-4">
        {/* Comparison Table */}
        <section className="flex-1 bg-white rounded shadow p-0 md:p-4 overflow-x-auto">
          <div className="grid grid-cols-1 md:grid-cols-3 gap-0 md:gap-4">
            {/* Column Headers */}
            <div className="font-bold text-center py-2 border-b">CDD Info</div>
            <div className="font-bold text-center py-2 border-b">Companies House</div>
            <div className="font-bold text-center py-2 border-b">Customer System</div>
            {/* Data Rows */}
            {fields.map((f) => (
              <React.Fragment key={f.key}>
                {/* CDD Info (editable in real app) */}
                <div className={`py-2 px-2 border-b flex items-center ${getStatus(f.key) === 'conflict' ? 'bg-red-50' : getStatus(f.key) === 'missing' ? 'bg-yellow-50' : ''}`}>
                  <span className={`w-2 h-2 rounded-full mr-2 ${getStatus(f.key) === 'conflict' ? 'bg-conflict' : getStatus(f.key) === 'missing' ? 'bg-missing' : 'bg-match'}`}></span>
                  <span>{mockComparison.cdd[f.key]}</span>
                </div>
                {/* Companies House (read-only) */}
                <div className="py-2 px-2 border-b text-gray-700">{mockComparison.companiesHouse[f.key]}</div>
                {/* Customer System (read-only) */}
                <div className="py-2 px-2 border-b text-gray-700">{mockComparison.customerSystem[f.key]}</div>
              </React.Fragment>
            ))}
          </div>
        </section>
        {/* Sidebar */}
        <div className="w-full md:w-80 mt-4 md:mt-0 md:ml-4">
          <Sidebar />
        </div>
      </main>
    </div>
  );
}

export default App;
